package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.HistoricoPontuacaoDto;

import java.util.List;

public interface HistoricoPontuacaoService {
    List<HistoricoPontuacaoDto> listarTodos();
    HistoricoPontuacaoDto buscarPorId(Long id);
    HistoricoPontuacaoDto criar(HistoricoPontuacaoDto dto);
    HistoricoPontuacaoDto atualizar(Long id, HistoricoPontuacaoDto dto);
    void excluir(Long id);
}