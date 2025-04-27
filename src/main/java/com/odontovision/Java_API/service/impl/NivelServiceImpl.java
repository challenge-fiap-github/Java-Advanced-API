package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.NivelDto;
import com.odontovision.Java_API.mapper.NivelMapper;
import com.odontovision.Java_API.repository.NivelRepository;
import com.odontovision.Java_API.service.NivelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NivelServiceImpl implements NivelService {

    private final NivelRepository nivelRepository;

    public NivelServiceImpl(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    @Override
    public List<NivelDto> listarNiveis() {
        return nivelRepository.findAll()
                .stream()
                .map(NivelMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
