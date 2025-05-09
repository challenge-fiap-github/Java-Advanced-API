package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Conquista}
 */
public record ConquistaDto(Long id, @NotNull @Size(max = 100) String nome, @NotNull @Size(max = 255) String descricao,
                           Long pontosBonus, LocalDate dataExpiracao) implements Serializable {
}