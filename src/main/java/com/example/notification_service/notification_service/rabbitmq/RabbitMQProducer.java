package com.example.notification_service.notification_service.rabbitmq;
import com.example.notification_service.notification_service.controller.MensagemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(MensagemDTO mensagem) {

        Map mensagemMap = objectMapper.convertValue(mensagem, Map.class);

        rabbitTemplate.convertAndSend("email_queue", mensagemMap);
    }

}