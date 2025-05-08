package com.odontovision.Java_API.exception;

public class EnderecoClinicaNotFoundException extends RuntimeException {
    public EnderecoClinicaNotFoundException(Long id) {
        super("Endereço da clínica não encontrado: " + id);
    }
}