package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link com.odontovision.Java_API.entity.PlanoCobertura}
 */
public record PlanoCoberturaDto(
        Long id,
        @NotNull Long planoId,
        @NotNull @Size(max = 255) String descricao
) implements Serializable {
}