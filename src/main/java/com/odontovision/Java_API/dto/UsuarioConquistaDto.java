package com.odontovision.Java_API.dto;

import java.io.Serializable;
import java.time.LocalDate;

public record UsuarioConquistaDto(
        Long usuarioId,
        Long conquistaId,
        LocalDate dataObtencao
) implements Serializable {
}
