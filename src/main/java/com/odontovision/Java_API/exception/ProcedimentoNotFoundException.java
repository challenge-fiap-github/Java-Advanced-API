package com.odontovision.Java_API.exception;

public class ProcedimentoNotFoundException extends ResourceNotFoundException {
    public ProcedimentoNotFoundException(Long id) {
        super("Procedimento", id);
    }
}
