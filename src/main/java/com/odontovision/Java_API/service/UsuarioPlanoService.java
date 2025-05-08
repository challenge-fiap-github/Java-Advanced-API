package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.UsuarioPlanoDto;

import java.util.List;

public interface UsuarioPlanoService {
    List<UsuarioPlanoDto> listarTodos();
    UsuarioPlanoDto buscarPorId(Long id);
    UsuarioPlanoDto criar(UsuarioPlanoDto dto);
    UsuarioPlanoDto atualizar(Long id, UsuarioPlanoDto dto);
}