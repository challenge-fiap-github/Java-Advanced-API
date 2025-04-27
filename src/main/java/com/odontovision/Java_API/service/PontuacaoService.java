package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.PontuacaoResponseDto;

import java.util.List;

public interface PontuacaoService {
    List<PontuacaoResponseDto> listarPontuacoesPorUsuario(Long usuarioId);
    List<PontuacaoResponseDto> listarTodasPontuacoes();
}
