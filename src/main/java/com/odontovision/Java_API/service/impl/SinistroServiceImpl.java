package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.SinistroRequestDto;
import com.odontovision.Java_API.dto.SinistroResponseDto;
import com.odontovision.Java_API.entity.Sinistro;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.Procedimento;
import com.odontovision.Java_API.exception.SinistroNotFoundException;
import com.odontovision.Java_API.exception.ProcedimentoNotFoundException;
import com.odontovision.Java_API.mapper.SinistroMapper;
import com.odontovision.Java_API.repository.SinistroRepository;
import com.odontovision.Java_API.repository.ProcedimentoRepository;
import com.odontovision.Java_API.service.SinistroService;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SinistroServiceImpl implements SinistroService {

    private final SinistroRepository repo;
    private final UsuarioService usuarioService;
    private final ProcedimentoRepository procedimentoRepo;

    public SinistroServiceImpl(
            SinistroRepository repo,
            UsuarioService usuarioService,
            ProcedimentoRepository procedimentoRepo
    ) {
        this.repo = repo;
        this.usuarioService = usuarioService;
        this.procedimentoRepo = procedimentoRepo;
    }

    @Override
    public List<SinistroResponseDto> listarTodos() {
        return repo.findAll().stream()
                .map(SinistroMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public SinistroResponseDto buscarPorId(Long id) {
        return repo.findById(id)
                .map(SinistroMapper::toResponseDto)
                .orElseThrow(() -> new SinistroNotFoundException(id));
    }

    @Override
    public SinistroResponseDto criar(SinistroRequestDto dto) {
        Usuario paciente = usuarioService.buscarEntidadePorId(dto.pacienteId());
        Procedimento proc = procedimentoRepo.findById(dto.procedimentoId())
                .orElseThrow(() -> new ProcedimentoNotFoundException(dto.procedimentoId()));
        Sinistro s = SinistroMapper.toEntity(dto, paciente, proc);
        Sinistro salvo = repo.save(s);
        return SinistroMapper.toResponseDto(salvo);
    }

    @Override
    public SinistroResponseDto atualizar(Long id, SinistroRequestDto dto) {
        Sinistro existente = repo.findById(id)
                .orElseThrow(() -> new SinistroNotFoundException(id));
        Usuario paciente = usuarioService.buscarEntidadePorId(dto.pacienteId());
        Procedimento proc = procedimentoRepo.findById(dto.procedimentoId())
                .orElseThrow(() -> new ProcedimentoNotFoundException(dto.procedimentoId()));
        existente.setPaciente(paciente);
        existente.setProcedimento(proc);
        existente.setDataSinistro(dto.dataSinistro());
        existente.setRiscoFraude(dto.riscoFraude());
        existente.setDescricaoRisco(dto.descricaoRisco());
        Sinistro atualizado = repo.save(existente);
        return SinistroMapper.toResponseDto(atualizado);
    }

    @Override
    public void excluir(Long id) {
        Sinistro s = repo.findById(id)
                .orElseThrow(() -> new SinistroNotFoundException(id));
        repo.delete(s);
    }
}