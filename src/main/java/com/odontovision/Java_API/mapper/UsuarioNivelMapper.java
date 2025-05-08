// src/main/java/com/odontovision/Java_API/mapper/UsuarioNivelMapper.java
package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.UsuarioNivelDto;
import com.odontovision.Java_API.entity.UsuarioNivel;
import com.odontovision.Java_API.entity.UsuarioNivelId;

public final class UsuarioNivelMapper {

    private UsuarioNivelMapper() {}

    public static UsuarioNivelDto toDto(UsuarioNivel e) {
        return new UsuarioNivelDto(
                e.getUsuario().getId(),
                e.getNivel().getId(),
                e.getPontosAtuais(),
                e.getDataUltimaAtualizacao()
        );
    }

    public static UsuarioNivel toEntity(UsuarioNivelDto dto,
                                        com.odontovision.Java_API.entity.Usuario usuario,
                                        com.odontovision.Java_API.entity.Nivel nivel) {
        UsuarioNivel e = new UsuarioNivel();
        e.setId(new UsuarioNivelId(dto.usuarioId(), dto.nivelId()));
        e.setUsuario(usuario);
        e.setNivel(nivel);
        e.setPontosAtuais(dto.pontosAtuais());
        e.setDataUltimaAtualizacao(dto.dataUltimaAtualizacao());
        return e;
    }
}