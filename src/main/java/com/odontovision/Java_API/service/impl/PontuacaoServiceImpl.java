package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.PontuacaoResponseDto;
import com.odontovision.Java_API.repository.PontuacaoRepository;
import com.odontovision.Java_API.service.PontuacaoService;
import com.odontovision.Java_API.mapper.PontuacaoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PontuacaoServiceImpl implements PontuacaoService {

    private final PontuacaoRepository pontuacaoRepository;

    public PontuacaoServiceImpl(PontuacaoRepository pontuacaoRepository) {
        this.pontuacaoRepository = pontuacaoRepository;
    }

    @Override
    public List<PontuacaoResponseDto> listarPontuacoesPorUsuario(Long usuarioId) {
        return pontuacaoRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(PontuacaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PontuacaoResponseDto> listarTodasPontuacoes() {
        return pontuacaoRepository.findAll()
                .stream()
                .map(PontuacaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
