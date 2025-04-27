package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.RecompensaResponseDto;
import com.odontovision.Java_API.entity.Recompensa;
import com.odontovision.Java_API.mapper.RecompensaMapper;
import com.odontovision.Java_API.repository.RecompensaRepository;
import com.odontovision.Java_API.service.RecompensaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecompensaServiceImpl implements RecompensaService {

    private final RecompensaRepository recompensaRepository;

    public RecompensaServiceImpl(RecompensaRepository recompensaRepository) {
        this.recompensaRepository = recompensaRepository;
    }

    @Override
    public List<RecompensaResponseDto> listarRecompensas() {
        return recompensaRepository.findAll()
                .stream()
                .map(RecompensaMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
