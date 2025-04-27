package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Diagnostico}
 */
public record DiagnosticoResponseDto(Long id, @NotNull Long consultaId, @NotNull @Size(max = 255) String descricao,
                                     @NotNull LocalDate data) implements Serializable {
}