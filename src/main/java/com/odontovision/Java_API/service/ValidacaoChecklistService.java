package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.ValidacaoChecklistDto;
import java.util.List;

public interface ValidacaoChecklistService {
    List<ValidacaoChecklistDto> listarTodos();
    ValidacaoChecklistDto buscarPorId(Long id);
    ValidacaoChecklistDto criar(ValidacaoChecklistDto dto);
    ValidacaoChecklistDto atualizar(Long id, ValidacaoChecklistDto dto);
    void deletar(Long id);
}