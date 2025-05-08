package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.UsuarioConquistaDto;
import com.odontovision.Java_API.entity.UsuarioConquista;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.Conquista;
import com.odontovision.Java_API.entity.UsuarioConquistaId;

public final class UsuarioConquistaMapper {

    private UsuarioConquistaMapper() {}

    /** Entidade → DTO */
    public static UsuarioConquistaDto toDto(UsuarioConquista uc) {
        return new UsuarioConquistaDto(
                uc.getUsuario().getId(),
                uc.getConquista().getId(),
                uc.getDataObtencao()
        );
    }

    /** DTO + entidades relacionadas → Entidade */
    public static UsuarioConquista toEntity(UsuarioConquistaDto dto,
                                            Usuario usuario,
                                            Conquista conquista) {
        UsuarioConquista uc = new UsuarioConquista();
        uc.setId(new UsuarioConquistaId(dto.usuarioId(), dto.conquistaId()));
        uc.setUsuario(usuario);
        uc.setConquista(conquista);
        uc.setDataObtencao(dto.dataObtencao());
        return uc;
    }
}