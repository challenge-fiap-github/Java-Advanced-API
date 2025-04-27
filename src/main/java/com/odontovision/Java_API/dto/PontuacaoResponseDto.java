package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Pontuacao}
 */
public record PontuacaoResponseDto(Long id, @NotNull Long usuarioId, @NotNull Long pontos,
                                   @NotNull LocalDate dataRegistro, LocalDate cicloInicial,
                                   LocalDate cicloFinal) implements Serializable {
}