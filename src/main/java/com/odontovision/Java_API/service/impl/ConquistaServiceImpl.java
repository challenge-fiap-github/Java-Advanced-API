package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.ConquistaDto;
import com.odontovision.Java_API.mapper.ConquistaMapper;
import com.odontovision.Java_API.repository.ConquistaRepository;
import com.odontovision.Java_API.service.ConquistaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConquistaServiceImpl implements ConquistaService {

    private final ConquistaRepository conquistaRepository;

    public ConquistaServiceImpl(ConquistaRepository conquistaRepository) {
        this.conquistaRepository = conquistaRepository;
    }

    @Override
    public List<ConquistaDto> listarConquistas() {
        return conquistaRepository.findAll()
                .stream()
                .map(ConquistaMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
