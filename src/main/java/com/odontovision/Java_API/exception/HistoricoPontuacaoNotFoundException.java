package com.odontovision.Java_API.exception;

public class HistoricoPontuacaoNotFoundException extends ResourceNotFoundException {
    public HistoricoPontuacaoNotFoundException(Long id) {
        super("HistoricoPontuacao", id);
    }
}