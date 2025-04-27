package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Consulta}
 */
public record ConsultaResponseDto(Long id, @NotNull Instant dataHora, @NotNull Long usuarioId, @NotNull Long dentistaId,
                                  @NotNull Long statusId, @NotNull Long tipoConsultaId,
                                  @Size(max = 255) String observacoes) implements Serializable {
}