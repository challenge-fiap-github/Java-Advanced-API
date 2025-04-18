package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.ChecklistDiario}
 */
public record ChecklistDiarioDto(Long id, @NotNull Long usuarioId, @NotNull LocalDate data, Boolean escovacao,
                                 Boolean fioDental, Long consultaValidacaoId) implements Serializable {
}