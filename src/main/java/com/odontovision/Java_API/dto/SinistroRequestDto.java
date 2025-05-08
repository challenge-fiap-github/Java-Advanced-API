package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

public record SinistroRequestDto(
        @NotNull Long pacienteId,
        @NotNull Long procedimentoId,
        LocalDate dataSinistro,
        @NotNull Boolean riscoFraude,
        @Size(max = 255) String descricaoRisco
) implements Serializable {}