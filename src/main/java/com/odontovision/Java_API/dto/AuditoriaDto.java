package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Auditoria}
 */
public record AuditoriaDto(Long id, @NotNull @Size(max = 50) String tabelaAfetada,
                           @NotNull @Size(max = 10) String tipoOperacao, Long usuarioId, Instant dataOperacao,
                           String valoresAntigos, String valoresNovos) implements Serializable {
}