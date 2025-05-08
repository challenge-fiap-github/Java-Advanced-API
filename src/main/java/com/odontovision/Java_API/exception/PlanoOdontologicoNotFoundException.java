package com.odontovision.Java_API.exception;

// 2) Quando não encontrar o PlanoOdontologico associado
public class PlanoOdontologicoNotFoundException extends ResourceNotFoundException {
    public PlanoOdontologicoNotFoundException(Long id) {
        super("PlanoOdontologico", id);
    }
}
