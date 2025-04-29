package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.DiagnosticoRequestDto;
import com.odontovision.Java_API.dto.DiagnosticoResponseDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.Diagnostico;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.DiagnosticoMapper;
import com.odontovision.Java_API.repository.ConsultaRepository;
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
    private final ConsultaRepository consultaRepository;

    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository,
                                  ConsultaRepository consultaRepository) {
        this.diagnosticoRepository = diagnosticoRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public DiagnosticoResponseDto criarDiagnostico(DiagnosticoRequestDto dto) {
        // Busca a consulta referenciada pelo DTO
        Consulta consulta = consultaRepository.findById(dto.getConsultaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Consulta não encontrada com ID: " + dto.getConsultaId()));

        // Cria e popula o Diagnóstico
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setConsulta(consulta);
        diagnostico.setDescricao(dto.getDescricao());
        diagnostico.setData(dto.getData());

        // Persiste e retorna o DTO de resposta
        Diagnostico salvo = diagnosticoRepository.save(diagnostico);
        return DiagnosticoMapper.toResponseDto(salvo);
    }

    @Override
    public DiagnosticoResponseDto atualizarDiagnostico(Long id, DiagnosticoRequestDto dto) {
        // Recupera o diagnóstico existente
        Diagnostico existente = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Diagnóstico não encontrado com ID: " + id));

        // Atualiza a associação de Consulta
        Consulta consulta = consultaRepository.findById(dto.getConsultaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Consulta não encontrada com ID: " + dto.getConsultaId()));
        existente.setConsulta(consulta);

        // Atualiza demais campos
        existente.setDescricao(dto.getDescricao());
        existente.setData(dto.getData());

        // Persiste e retorna o DTO atualizado
        Diagnostico atualizado = diagnosticoRepository.save(existente);
        return DiagnosticoMapper.toResponseDto(atualizado);
    }

    @Override
    public void deletarDiagnostico(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Diagnóstico não encontrado com ID: " + id));
        diagnosticoRepository.delete(diagnostico);
    }

    @Override
    public DiagnosticoResponseDto buscarPorId(Long id) {
        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Diagnóstico não encontrado com ID: " + id));
        return DiagnosticoMapper.toResponseDto(diagnostico);
    }

    @Override
    public List<DiagnosticoResponseDto> listarTodos() {
        return diagnosticoRepository.findAll().stream()
                .map(DiagnosticoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}