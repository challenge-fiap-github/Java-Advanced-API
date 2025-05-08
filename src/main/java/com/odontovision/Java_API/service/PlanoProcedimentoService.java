package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.PlanoProcedimentoDto;

import java.util.List;

public interface PlanoProcedimentoService {
    List<PlanoProcedimentoDto> listarTodos();
    PlanoProcedimentoDto buscarPorId(Long planoId, Long procedimentoId);
    PlanoProcedimentoDto criar(PlanoProcedimentoDto dto);
    void excluir(Long planoId, Long procedimentoId);
}