package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.HistoricoTratamentoDto;
import com.odontovision.Java_API.entity.Dentista;
import com.odontovision.Java_API.entity.HistoricoTratamento;
import com.odontovision.Java_API.entity.Procedimento;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.exception.DentistaNotFoundException;
import com.odontovision.Java_API.exception.HistoricoTratamentoNotFoundException;
import com.odontovision.Java_API.exception.ProcedimentoNotFoundException;
import com.odontovision.Java_API.exception.UsuarioNotFoundException;
import com.odontovision.Java_API.mapper.HistoricoTratamentoMapper;
import com.odontovision.Java_API.repository.DentistaRepository;
import com.odontovision.Java_API.repository.HistoricoTratamentoRepository;
import com.odontovision.Java_API.repository.ProcedimentoRepository;
import com.odontovision.Java_API.service.HistoricoTratamentoService;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HistoricoTratamentoServiceImpl implements HistoricoTratamentoService {

    private final HistoricoTratamentoRepository repo;
    private final UsuarioService usuarioService;
    private final ProcedimentoRepository procedimentoRepo;
    private final DentistaRepository dentistaRepo;

    public HistoricoTratamentoServiceImpl(HistoricoTratamentoRepository repo,
                                          UsuarioService usuarioService,
                                          ProcedimentoRepository procedimentoRepo,
                                          DentistaRepository dentistaRepo) {
        this.repo = repo;
        this.usuarioService = usuarioService;
        this.procedimentoRepo = procedimentoRepo;
        this.dentistaRepo = dentistaRepo;
    }

    @Override
    public List<HistoricoTratamentoDto> listarTodos() {
        return repo.findAll().stream()
                .map(HistoricoTratamentoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HistoricoTratamentoDto buscarPorId(Long id) {
        return repo.findById(id)
                .map(HistoricoTratamentoMapper::toDto)
                .orElseThrow(() -> new HistoricoTratamentoNotFoundException(id));
    }

    @Override
    public HistoricoTratamentoDto criar(HistoricoTratamentoDto dto) {
        // busca as entidades relacionadas
        Usuario usuario = usuarioService.buscarEntidadePorId(dto.usuarioId())
                .orElseThrow(() -> new UsuarioNotFoundException(dto.usuarioId()));
        Procedimento procedimento = procedimentoRepo.findById(dto.procedimentoId())
                .orElseThrow(() -> new ProcedimentoNotFoundException(dto.procedimentoId()));
        Dentista dentista = dentistaRepo.findById(dto.dentistaId())
                .orElseThrow(() -> new DentistaNotFoundException(dto.dentistaId()));

        // converte e persiste
        HistoricoTratamento entidade = HistoricoTratamentoMapper.toEntity(dto, usuario, procedimento, dentista);
        HistoricoTratamento salvo = repo.save(entidade);
        return HistoricoTratamentoMapper.toDto(salvo);
    }

    @Override
    public HistoricoTratamentoDto atualizar(Long id, HistoricoTratamentoDto dto) {
        HistoricoTratamento existente = repo.findById(id)
                .orElseThrow(() -> new HistoricoTratamentoNotFoundException(id));

        Usuario usuario = usuarioService.buscarEntidadePorId(dto.usuarioId())
                .orElseThrow(() -> new UsuarioNotFoundException(dto.usuarioId()));
        Procedimento procedimento = procedimentoRepo.findById(dto.procedimentoId())
                .orElseThrow(() -> new ProcedimentoNotFoundException(dto.procedimentoId()));
        Dentista dentista = dentistaRepo.findById(dto.dentistaId())
                .orElseThrow(() -> new DentistaNotFoundException(dto.dentistaId()));

        existente.setUsuario(usuario);
        existente.setProcedimento(procedimento);
        existente.setDentista(dentista);
        existente.setData(dto.data());
        existente.setObservacoes(dto.observacoes());

        HistoricoTratamento atualizado = repo.save(existente);
        return HistoricoTratamentoMapper.toDto(atualizado);
    }

    @Override
    public void deletar(Long id) {
        repo.findById(id)
                .orElseThrow(() -> new HistoricoTratamentoNotFoundException(id));
        repo.deleteById(id);
    }
}