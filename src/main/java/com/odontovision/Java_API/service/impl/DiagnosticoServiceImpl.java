package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.DiagnosticoRequestDto;
import com.odontovision.Java_API.dto.DiagnosticoResponseDto;
import com.odontovision.Java_API.entity.Diagnostico;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.DiagnosticoMapper;
import com.odontovision.Java_API.repository.DiagnosticoRepository;
import com.odontovision.Java_API.service.DiagnosticoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DiagnosticoServiceImpl implements DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;

    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository) {
        this.diagnosticoRepository = diagnosticoRepository;
    }

    @Override
    public DiagnosticoResponseDto criarDiagnostico(DiagnosticoRequestDto dto) {
        Diagnostico diagnostico = DiagnosticoMapper.toEntity(dto);
        Diagnostico salvo = diagnosticoRepository.save(diagnostico);
        return DiagnosticoMapper.toResponseDto(salvo);
    }

    @Override
    public DiagnosticoResponseDto atualizarDiagnostico(Long id, DiagnosticoRequestDto dto) {
        Diagnostico existente = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnóstico não encontrado com ID: " + id));

        existente.setConsultaId(dto.getConsultaId());
        existente.setDescricao(dto.getDescricao());
        existente.setData(dto.getData());

        Diagnostico atualizado = diagnosticoRepository.save(existente);
        return DiagnosticoMapper.toResponseDto(atualizado);
    }

    @Override
    public void deletarDiagnostico(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnóstico não encontrado com ID: " + id));
        diagnosticoRepository.delete(diagnostico);
    }

    @Override
    public DiagnosticoResponseDto buscarPorId(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnóstico não encontrado com ID: " + id));
        return DiagnosticoMapper.toResponseDto(diagnostico);
    }

    @Override
    public List<DiagnosticoResponseDto> listarTodos() {
        return diagnosticoRepository.findAll()
                .stream()
                .map(DiagnosticoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
