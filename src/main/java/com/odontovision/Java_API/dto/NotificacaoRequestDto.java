package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

public record NotificacaoRequestDto(
        @NotNull @Size(max = 100) String titulo,
        @NotNull @Size(max = 255) String conteudo,
        @NotNull Long usuarioId
) implements Serializable {}