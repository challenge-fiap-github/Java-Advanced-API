package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.HistoricoPontuacao}
 */
public record HistoricoPontuacaoDto(Long id, @NotNull Long usuarioId, LocalDate dataConsulta, Long pontosGanhos,
                                    Long pontosTotais) implements Serializable {
}