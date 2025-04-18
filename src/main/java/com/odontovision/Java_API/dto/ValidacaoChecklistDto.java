package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.ValidacaoChecklist}
 */
public record ValidacaoChecklistDto(Long id, @NotNull Long usuarioId, @NotNull Long consultaId, LocalDate dataValidacao,
                                    Boolean statusValidacao, Long pontosBonus) implements Serializable {
}