package com.odontovision.Java_API.exception;

// 1) Quando não encontrar o próprio PlanoCobertura
public class PlanoCoberturaNotFoundException extends ResourceNotFoundException {
    public PlanoCoberturaNotFoundException(Long id) {
        super("PlanoCobertura", id);
    }
}