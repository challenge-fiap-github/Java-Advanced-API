package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.odontovision.Java_API.entity.UsuarioNivel}
 */
public record UsuarioNivelDto(
        @NotNull Long usuarioId,
        @NotNull Long nivelId,
        @NotNull Long pontosAtuais,
        LocalDate dataUltimaAtualizacao
) implements Serializable {
}