package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.TipoConsultaDto;
import com.odontovision.Java_API.mapper.TipoConsultaMapper;
import com.odontovision.Java_API.repository.TipoConsultaRepository;
import com.odontovision.Java_API.service.TipoConsultaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TipoConsultaServiceImpl implements TipoConsultaService {

    private final TipoConsultaRepository tipoConsultaRepository;

    public TipoConsultaServiceImpl(TipoConsultaRepository tipoConsultaRepository) {
        this.tipoConsultaRepository = tipoConsultaRepository;
    }

    @Override
    public List<TipoConsultaDto> listarTiposConsulta() {
        return tipoConsultaRepository.findAll()
                .stream()
                .map(TipoConsultaMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
