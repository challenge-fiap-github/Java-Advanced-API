package com.odontovision.Java_API.exception;

public class UsuarioNotFoundException extends ResourceNotFoundException {
    public UsuarioNotFoundException(Long id) {
        super("Usuario", id);
    }
}