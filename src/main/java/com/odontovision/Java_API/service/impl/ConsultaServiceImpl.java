package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.ConsultaRequestDto;
import com.odontovision.Java_API.dto.ConsultaResponseDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.ConsultaMapper;
import com.odontovision.Java_API.repository.ConsultaRepository;
import com.odontovision.Java_API.service.ConsultaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public ConsultaResponseDto criarConsulta(ConsultaRequestDto dto) {
        Consulta consulta = ConsultaMapper.toEntity(dto);
        Consulta salvo = consultaRepository.save(consulta);
        return ConsultaMapper.toResponseDto(salvo);
    }

    @Override
    public ConsultaResponseDto atualizarConsulta(Long id, ConsultaRequestDto dto) {
        Consulta existente = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));

        existente.setDataHora(dto.getDataHora());
        existente.setUsuarioId(dto.getUsuarioId());
        existente.setDentistaId(dto.getDentistaId());
        existente.setStatusId(dto.getStatusId());
        existente.setTipoConsultaId(dto.getTipoConsultaId());
        existente.setObservacoes(dto.getObservacoes());

        Consulta atualizado = consultaRepository.save(existente);
        return ConsultaMapper.toResponseDto(atualizado);
    }

    @Override
    public void deletarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
        consultaRepository.delete(consulta);
    }

    @Override
    public ConsultaResponseDto buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
        return ConsultaMapper.toResponseDto(consulta);
    }

    @Override
    public List<ConsultaResponseDto> listarTodas() {
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
