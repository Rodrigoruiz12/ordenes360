package com.botilleria.ordenes.service;

import com.botilleria.ordenes.model.Orden;
import com.botilleria.ordenes.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class OrdenService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Orden crearOrden(Orden orden) {
        orden.setId(UUID.randomUUID().toString());
        // Simular guardado en BD
        
        // Publicar evento en RabbitMQ
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orden);
        System.out.println("Orden creada y evento publicado: " + orden.getId());
        
        return orden;
    }
}
