package com.odontovision.Java_API.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.odontovision.Java_API.config.RabbitMQConfig.QUEUE;

@Service
public class MessageConsumer {

    @RabbitListener(queues = QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
