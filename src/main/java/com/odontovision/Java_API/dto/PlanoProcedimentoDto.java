package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO para {@link com.odontovision.Java_API.entity.PlanoProcedimento}
 */
public record PlanoProcedimentoDto(
        @NotNull Long planoId,
        @NotNull Long procedimentoId
) implements Serializable {
}