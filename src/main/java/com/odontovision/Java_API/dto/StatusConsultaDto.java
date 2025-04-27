package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.odontovision.Java_API.entity.StatusConsulta}
 */
public record StatusConsultaDto(Long id, @NotNull @Size(max = 20) String descricao) implements Serializable {
}