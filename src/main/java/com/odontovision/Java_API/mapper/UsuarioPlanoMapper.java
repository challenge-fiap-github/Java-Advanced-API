package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.UsuarioPlanoDto;
import com.odontovision.Java_API.entity.UsuarioPlano;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.PlanoOdontologico;

public final class UsuarioPlanoMapper {

    private UsuarioPlanoMapper() {}

    public static UsuarioPlanoDto toDto(UsuarioPlano e) {
        return new UsuarioPlanoDto(
                e.getId(),
                e.getUsuario().getId(),
                e.getPlano().getId(),
                e.getDataAdesao()
        );
    }

    public static UsuarioPlano toEntity(UsuarioPlanoDto dto,
                                        Usuario usuario,
                                        PlanoOdontologico plano) {
        UsuarioPlano e = new UsuarioPlano();
        if (dto.getId() != null) {
            e.setId(dto.getId());
        }
        e.setUsuario(usuario);
        e.setPlano(plano);
        e.setDataAdesao(dto.getDataAdesao());
        return e;
    }
}