package com.odontovision.Java_API.exception;

public class UsuarioPlanoNotFoundException extends ResourceNotFoundException {
    public UsuarioPlanoNotFoundException(Long id) {
        super("UsuarioPlano", id);
    }
}