package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.EnderecoUsuarioDto;

import java.util.List;

public interface EnderecoUsuarioService {

    EnderecoUsuarioDto criar(Long usuarioId, EnderecoUsuarioDto dto);

    EnderecoUsuarioDto atualizar(Long id, Long usuarioId, EnderecoUsuarioDto dto);

    void deletar(Long id);

    EnderecoUsuarioDto buscarPorId(Long id);

    List<EnderecoUsuarioDto> listarTodos();
}