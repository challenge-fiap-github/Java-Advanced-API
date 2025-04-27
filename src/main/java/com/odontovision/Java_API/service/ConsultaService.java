package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.ConsultaRequestDto;
import com.odontovision.Java_API.dto.ConsultaResponseDto;

import java.util.List;

public interface ConsultaService {
    ConsultaResponseDto criarConsulta(ConsultaRequestDto dto);
    ConsultaResponseDto atualizarConsulta(Long id, ConsultaRequestDto dto);
    void deletarConsulta(Long id);
    ConsultaResponseDto buscarPorId(Long id);
    List<ConsultaResponseDto> listarTodas();
}
