package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.ProcedimentoRequestDto;
import com.odontovision.Java_API.dto.ProcedimentoResponseDto;

import java.util.List;

public interface ProcedimentoService {
    List<ProcedimentoResponseDto> listarTodos();
    ProcedimentoResponseDto buscarPorId(Long id);
    ProcedimentoResponseDto criar(ProcedimentoRequestDto dto);
    ProcedimentoResponseDto atualizar(Long id, ProcedimentoRequestDto dto);
    void excluir(Long id);
}