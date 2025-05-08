package com.odontovision.Java_API.exception;

public class UsuarioConquistaNotFoundException extends RuntimeException {
    public UsuarioConquistaNotFoundException(Long usuarioId, Long conquistaId) {
        super("UsuarioConquista não encontrado: usuarioId="
                + usuarioId + ", conquistaId=" + conquistaId);
    }
}