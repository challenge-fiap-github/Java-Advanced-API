package com.odontovision.Java_API.exception;

public class HistoricoTratamentoNotFoundException extends ResourceNotFoundException {
    public HistoricoTratamentoNotFoundException(Long id) {
        super("HistoricoTratamento", id);
    }
}
