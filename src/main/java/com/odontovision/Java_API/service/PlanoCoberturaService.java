package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.PlanoCoberturaDto;

import java.util.List;

public interface PlanoCoberturaService {
    List<PlanoCoberturaDto> listarTodos();
    PlanoCoberturaDto buscarPorId(Long id);
    PlanoCoberturaDto criar(PlanoCoberturaDto dto);
    PlanoCoberturaDto atualizar(Long id, PlanoCoberturaDto dto);
    void excluir(Long id);
}