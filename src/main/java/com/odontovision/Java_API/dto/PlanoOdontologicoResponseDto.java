package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.PlanoOdontologico}
 */
public record PlanoOdontologicoResponseDto(
        @NotNull Long id,
        @NotNull @Size(max = 100) String nomePlano,
        @Size(max = 255) String descricao,
        BigDecimal preco,
        LocalDate validade
) implements Serializable {
}
