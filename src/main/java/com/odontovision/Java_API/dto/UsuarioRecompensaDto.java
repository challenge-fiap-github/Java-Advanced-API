package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.UsuarioRecompensa}
 */
public record UsuarioRecompensaDto(Long id, @NotNull Long usuarioId, @NotNull Long recompensaId,
                                   LocalDate dataResgate) implements Serializable {
}