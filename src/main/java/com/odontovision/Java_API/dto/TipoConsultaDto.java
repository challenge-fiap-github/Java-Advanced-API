package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.odontovision.Java_API.entity.TipoConsulta}
 */
public record TipoConsultaDto(Long id, @NotNull @Size(max = 50) String descricao) implements Serializable {
}