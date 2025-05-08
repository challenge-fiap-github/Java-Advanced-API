package com.odontovision.Java_API.exception;

public class SinistroNotFoundException extends ResourceNotFoundException {
    public SinistroNotFoundException(Long id) {
        super("Sinistro", id);
    }
}