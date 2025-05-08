package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.ProcedimentoRequestDto;
import com.odontovision.Java_API.dto.ProcedimentoResponseDto;
import com.odontovision.Java_API.entity.Procedimento;
import com.odontovision.Java_API.exception.ProcedimentoNotFoundException;
import com.odontovision.Java_API.mapper.ProcedimentoMapper;
import com.odontovision.Java_API.repository.ProcedimentoRepository;
import com.odontovision.Java_API.service.ProcedimentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcedimentoServiceImpl implements ProcedimentoService {

    private final ProcedimentoRepository repository;

    public ProcedimentoServiceImpl(ProcedimentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProcedimentoResponseDto> listarTodos() {
        return repository.findAll().stream()
                .map(ProcedimentoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProcedimentoResponseDto buscarPorId(Long id) {
        Procedimento entidade = repository.findById(id)
                .orElseThrow(() -> new ProcedimentoNotFoundException(id));
        return ProcedimentoMapper.toDto(entidade);
    }

    @Override
    public ProcedimentoResponseDto criar(ProcedimentoRequestDto dto) {
        Procedimento nova = ProcedimentoMapper.toEntity(dto);
        Procedimento salva = repository.save(nova);
        return ProcedimentoMapper.toDto(salva);
    }

    @Override
    public ProcedimentoResponseDto atualizar(Long id, ProcedimentoRequestDto dto) {
        Procedimento existente = repository.findById(id)
                .orElseThrow(() -> new ProcedimentoNotFoundException(id));

        existente.setNomeProcedimento(dto.getNomeProcedimento());
        existente.setDescricao(dto.getDescricao());
        existente.setCusto(dto.getCusto());

        Procedimento atualizado = repository.save(existente);
        return ProcedimentoMapper.toDto(atualizado);
    }

    @Override
    public void excluir(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ProcedimentoNotFoundException(id));
        repository.deleteById(id);
    }
}