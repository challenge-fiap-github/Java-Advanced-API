package com.odontovision.Java_API.exception;

public class NotificacaoNotFoundException extends ResourceNotFoundException {
    public NotificacaoNotFoundException(Long id) {
        super("Notificação", id);
    }
}