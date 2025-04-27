package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.PlanoOdontologicoRequestDto;
import com.odontovision.Java_API.dto.PlanoOdontologicoResponseDto;

import java.util.List;

public interface PlanoOdontologicoService {
    PlanoOdontologicoResponseDto criarPlano(PlanoOdontologicoRequestDto dto);
    PlanoOdontologicoResponseDto atualizarPlano(Long id, PlanoOdontologicoRequestDto dto);
    void deletarPlano(Long id);
    PlanoOdontologicoResponseDto buscarPorId(Long id);
    List<PlanoOdontologicoResponseDto> listarTodos();
}
