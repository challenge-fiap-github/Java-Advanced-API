package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.messaging.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MessageProducer producer;

    public MensagemController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public void enviarMensagem(@RequestBody String mensagem) {
        producer.sendMessage(mensagem);
    }
}
