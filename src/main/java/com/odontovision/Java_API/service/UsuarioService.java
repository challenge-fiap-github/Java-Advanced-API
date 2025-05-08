package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.UsuarioRequestDTO;
import com.odontovision.Java_API.dto.UsuarioResponseDto;
import com.odontovision.Java_API.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    UsuarioResponseDto criarUsuario(UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseDto atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO);

    void deletarUsuario(Long id);

    UsuarioResponseDto buscarPorId(Long id);

    List<UsuarioResponseDto> listarTodos();

    Usuario buscarEntidadePorId(Long id);
}