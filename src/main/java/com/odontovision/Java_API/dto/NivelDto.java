package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Nivel}
 */
public record NivelDto(Long id, @NotNull @Size(max = 100) String descricao,
                       @NotNull Long pontosNecessarios) implements Serializable {
}