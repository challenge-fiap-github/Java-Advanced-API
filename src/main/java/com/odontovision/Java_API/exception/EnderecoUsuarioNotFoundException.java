package com.odontovision.Java_API.exception;

public class EnderecoUsuarioNotFoundException extends ResourceNotFoundException {
    public EnderecoUsuarioNotFoundException(Long id) {
        super("EnderecoUsuario", id);
    }
}