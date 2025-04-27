package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.odontovision.Java_API.entity.EnderecoUsuario}
 */
public record EnderecoUsuarioDto(Long id, @NotNull Long usuarioId, @Size(max = 150) String logradouro,
                                 @Size(max = 10) String numero, @Size(max = 100) String cidade,
                                 @Size(max = 50) String estado, @Size(max = 10) String cep,
                                 @Size(max = 100) String complemento) implements Serializable {
}