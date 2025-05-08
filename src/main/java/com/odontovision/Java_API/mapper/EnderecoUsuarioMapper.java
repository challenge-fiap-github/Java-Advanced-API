// src/main/java/com/odontovision/Java_API/mapper/EnderecoUsuarioMapper.java
package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.EnderecoUsuarioDto;
import com.odontovision.Java_API.entity.EnderecoUsuario;

/**
 * Conversões entre {@link EnderecoUsuario} e {@link EnderecoUsuarioDto}.
 */
public final class EnderecoUsuarioMapper {

    // não permite instanciação
    private EnderecoUsuarioMapper() {}

    /** Converte entidade → DTO */
    public static EnderecoUsuarioDto toDto(EnderecoUsuario e) {
        if (e == null) return null;
        return new EnderecoUsuarioDto(
                e.getId(),
                e.getUsuario().getId(),
                e.getLogradouro(),
                e.getNumero(),
                e.getCidade(),
                e.getEstado(),
                e.getCep(),
                e.getComplemento()
        );
    }

    /** Converte DTO → entidade (sem relacionamento) */
    public static EnderecoUsuario toEntity(EnderecoUsuarioDto dto) {
        if (dto == null) return null;
        EnderecoUsuario e = new EnderecoUsuario();
        // O setUsuario(...) fica a cargo do Service
        e.setLogradouro(dto.logradouro());
        e.setNumero(dto.numero());
        e.setCidade(dto.cidade());
        e.setEstado(dto.estado());
        e.setCep(dto.cep());
        e.setComplemento(dto.complemento());
        return e;
    }
}