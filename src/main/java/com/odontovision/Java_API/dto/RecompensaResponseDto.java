package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Recompensa}
 */
public record RecompensaResponseDto(Long id, @NotNull @Size(max = 255) String descricao,
                                    @NotNull Long pontosNecessarios, Long quantidadeDisponivel,
                                    LocalDate dataExpiracao) implements Serializable {
}