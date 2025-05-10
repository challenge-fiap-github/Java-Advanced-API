package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

public record AuditoriaDto(
        Long id,

        @NotNull @Size(max = 50)
        String tabelaAfetada,

        @NotNull @Size(max = 10)
        String tipoOperacao,

        Long usuarioId,

        @NotNull
        Instant dataOperacao,

        String valoresAntigos,
        String valoresNovos

) implements Serializable {}
