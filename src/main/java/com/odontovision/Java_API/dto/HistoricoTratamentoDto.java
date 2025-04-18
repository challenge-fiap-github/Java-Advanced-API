package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.HistoricoTratamento}
 */
public record HistoricoTratamentoDto(Long id, @NotNull Long usuarioId, @NotNull Long procedimentoId,
                                     @NotNull Long dentistaId, @NotNull LocalDate data,
                                     @Size(max = 255) String observacoes) implements Serializable {
}