package com.odontovision.Java_API.exception;

/**
 * Lançada quando não se encontra a validação de checklist pelo ID.
 */
public class ValidacaoChecklistNotFoundException extends ResourceNotFoundException {

    public ValidacaoChecklistNotFoundException(Long id) {
        super("ValidacaoChecklist não encontrada com ID: " + id);
    }
}