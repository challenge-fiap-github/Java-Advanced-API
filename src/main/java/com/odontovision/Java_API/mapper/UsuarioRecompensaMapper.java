package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.UsuarioRecompensaDto;
import com.odontovision.Java_API.entity.UsuarioRecompensa;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.Recompensa;

public final class UsuarioRecompensaMapper {

    private UsuarioRecompensaMapper() {

    }

    /** Entidade → DTO */
    public static UsuarioRecompensaDto toDto(UsuarioRecompensa ur) {
        if (ur == null) {
            return null;
        }
        return new UsuarioRecompensaDto(
                ur.getId(),
                ur.getUsuario().getId(),
                ur.getRecompensa().getId(),
                ur.getDataResgate()
        );
    }

    /**
     * DTO + entidades relacionadas → Entidade
     * @param dto record vindo da camada de controller
     * @param usuario instância carregada pelo service de Usuario
     * @param recompensa instância carregada pelo service de Recompensa
     */
    public static UsuarioRecompensa toEntity(UsuarioRecompensaDto dto,
                                             Usuario usuario,
                                             Recompensa recompensa) {
        UsuarioRecompensa ur = new UsuarioRecompensa();
        if (dto.id() != null) {
            ur.setId(dto.id());
        }
        ur.setUsuario(usuario);
        ur.setRecompensa(recompensa);
        ur.setDataResgate(dto.dataResgate());
        return ur;
    }
}