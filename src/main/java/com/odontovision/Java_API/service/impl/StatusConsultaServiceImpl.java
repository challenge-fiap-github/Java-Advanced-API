package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.StatusConsultaDto;
import com.odontovision.Java_API.entity.StatusConsulta;
import com.odontovision.Java_API.mapper.StatusConsultaMapper;
import com.odontovision.Java_API.repository.StatusConsultaRepository;
import com.odontovision.Java_API.service.StatusConsultaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StatusConsultaServiceImpl implements StatusConsultaService {

    private final StatusConsultaRepository statusConsultaRepository;

    public StatusConsultaServiceImpl(StatusConsultaRepository statusConsultaRepository) {
        this.statusConsultaRepository = statusConsultaRepository;
    }

    @Override
    public List<StatusConsultaDto> listarStatusConsultas() {
        return statusConsultaRepository.findAll()
                .stream()
                .map(StatusConsultaMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
