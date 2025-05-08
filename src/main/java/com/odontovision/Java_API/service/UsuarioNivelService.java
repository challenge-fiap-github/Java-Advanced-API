package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.UsuarioNivelDto;

import java.util.List;

public interface UsuarioNivelService {
    List<UsuarioNivelDto> listarTodos();
    UsuarioNivelDto buscarPorId(Long usuarioId, Long nivelId);
    UsuarioNivelDto criar(UsuarioNivelDto dto);
    UsuarioNivelDto atualizar(Long usuarioId, Long nivelId, UsuarioNivelDto dto);
}