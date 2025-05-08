package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.SinistroRequestDto;
import com.odontovision.Java_API.dto.SinistroResponseDto;
import java.util.List;

public interface SinistroService {
    List<SinistroResponseDto> listarTodos();
    SinistroResponseDto buscarPorId(Long id);
    SinistroResponseDto criar(SinistroRequestDto dto);
    SinistroResponseDto atualizar(Long id, SinistroRequestDto dto);
    void excluir(Long id);
}