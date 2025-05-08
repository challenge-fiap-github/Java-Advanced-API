package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.ConsultaProcedimentoDto;
import java.util.List;

public interface ConsultaProcedimentoService {
    List<ConsultaProcedimentoDto> listarTodos();
    ConsultaProcedimentoDto buscarPorId(Long consultaId, Long procedimentoId);
    ConsultaProcedimentoDto criar(ConsultaProcedimentoDto dto);
}