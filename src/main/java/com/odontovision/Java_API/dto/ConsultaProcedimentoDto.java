package com.odontovision.Java_API.dto;

import java.io.Serializable;

/**
 * DTO para ConsultaProcedimento (join table)
 */
public record ConsultaProcedimentoDto(
        Long consultaId,
        Long procedimentoId
) implements Serializable {}