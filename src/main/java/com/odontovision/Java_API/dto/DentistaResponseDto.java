package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Dentista}
 */
public record DentistaResponseDto(
        Long id,
        @NotNull @Size(max = 100) String nome,
        @NotNull @Size(max = 20) String cro,
        @Size(max = 100) String especialidade,
        @Size(max = 15) String telefone,
        @NotNull @Size(max = 100) String email
) implements Serializable {
}