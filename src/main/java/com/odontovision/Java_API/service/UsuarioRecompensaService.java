package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.UsuarioRecompensaDto;

import java.util.List;

public interface UsuarioRecompensaService {

    UsuarioRecompensaDto criarUsuarioRecompensa(UsuarioRecompensaDto dto);

    void deletarUsuarioRecompensa(Long id);

    UsuarioRecompensaDto buscarPorId(Long id);

    List<UsuarioRecompensaDto> listarTodos();
}
