package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.UsuarioConquistaDto;
import java.util.List;

public interface UsuarioConquistaService {
    List<UsuarioConquistaDto> listarTodos();
    UsuarioConquistaDto buscarPorId(Long usuarioId, Long conquistaId);
    UsuarioConquistaDto criar(UsuarioConquistaDto dto);
    UsuarioConquistaDto atualizar(Long usuarioId, Long conquistaId, UsuarioConquistaDto dto);
}