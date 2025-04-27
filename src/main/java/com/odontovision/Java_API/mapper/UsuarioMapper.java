package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.UsuarioRequestDTO;
import com.odontovision.Java_API.dto.UsuarioResponseDto;
import com.odontovision.Java_API.entity.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
        // construtor privado para não permitir instanciar
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setCpf(dto.getCpf());
        usuario.setTelefone(dto.getTelefone());
        return usuario;
    }

    public static UsuarioResponseDto toResponseDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataNascimento(),
                usuario.getCpf(),
                usuario.getTelefone()
        );
    }

}
