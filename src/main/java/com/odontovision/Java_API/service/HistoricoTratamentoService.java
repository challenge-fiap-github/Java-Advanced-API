package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.HistoricoTratamentoDto;

import java.util.List;

public interface HistoricoTratamentoService {

    List<HistoricoTratamentoDto> listarTodos();

    HistoricoTratamentoDto buscarPorId(Long id);

    HistoricoTratamentoDto criar(HistoricoTratamentoDto dto);

    HistoricoTratamentoDto atualizar(Long id, HistoricoTratamentoDto dto);

    void deletar(Long id);
}