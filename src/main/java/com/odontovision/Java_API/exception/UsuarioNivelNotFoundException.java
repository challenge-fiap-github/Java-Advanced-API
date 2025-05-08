package com.odontovision.Java_API.exception;

public class UsuarioNivelNotFoundException extends ResourceNotFoundException {
    public UsuarioNivelNotFoundException(Long usuarioId, Long nivelId) {
        super(
                String.format(
                        "Vínculo UsuarioNivel não encontrado para usuarioId=%d e nivelId=%d",
                        usuarioId, nivelId
                )
        );
    }
}