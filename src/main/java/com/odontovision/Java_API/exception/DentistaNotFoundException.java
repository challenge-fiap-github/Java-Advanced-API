package com.odontovision.Java_API.exception;

public class DentistaNotFoundException extends RuntimeException {
    public DentistaNotFoundException(Long id) {
        super("Dentista not found with id: " + id);
    }
}