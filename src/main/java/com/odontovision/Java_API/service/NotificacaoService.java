package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.NotificacaoRequestDto;
import com.odontovision.Java_API.dto.NotificacaoResponseDto;

import java.util.List;

public interface NotificacaoService {
    List<NotificacaoResponseDto> listarTodas();
    NotificacaoResponseDto buscarPorId(Long id);
    NotificacaoResponseDto criar(NotificacaoRequestDto dto);
    NotificacaoResponseDto atualizar(Long id, NotificacaoRequestDto dto);
    void excluir(Long id);
}