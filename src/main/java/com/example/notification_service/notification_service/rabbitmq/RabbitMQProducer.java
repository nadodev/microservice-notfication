package com.example.notification_service.notification_service.rabbitmq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(Map<String, String> mensagem) {
        rabbitTemplate.convertAndSend("email_queue", mensagem); 
    }

}