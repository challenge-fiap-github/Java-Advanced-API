package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.DiagnosticoRequestDto;
import com.odontovision.Java_API.dto.DiagnosticoResponseDto;

import java.util.List;

public interface DiagnosticoService {
    DiagnosticoResponseDto criarDiagnostico(DiagnosticoRequestDto dto);
    DiagnosticoResponseDto atualizarDiagnostico(Long id, DiagnosticoRequestDto dto);
    void deletarDiagnostico(Long id);
    DiagnosticoResponseDto buscarPorId(Long id);
    List<DiagnosticoResponseDto> listarTodos();
}
