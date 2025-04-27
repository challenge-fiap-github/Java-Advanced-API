package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.ChecklistDiarioDto;

import java.util.List;

public interface ChecklistDiarioService {
    ChecklistDiarioDto criarChecklist(ChecklistDiarioDto dto);
    ChecklistDiarioDto atualizarChecklist(Long id, ChecklistDiarioDto dto);
    void deletarChecklist(Long id);
    ChecklistDiarioDto buscarPorId(Long id);
    List<ChecklistDiarioDto> listarTodos();
}
