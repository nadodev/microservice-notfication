package com.example.notification_service.notification_service.controller;

import org.springframework.web.bind.annotation.*;

import com.example.notification_service.notification_service.rabbitmq.RabbitMQProducer;

import java.util.Map;

@RestController
@RequestMapping("/notificar")
public class NotificationController {

    private final RabbitMQProducer producer;

    public NotificationController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/email")
    public String enviarNotificacao(@RequestBody Map<String, String> mensagem) {
        producer.enviarMensagem(mensagem);
        return "Notificação enviada com sucesso!";
    }
}