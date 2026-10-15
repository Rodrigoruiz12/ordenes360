package com.botilleria.ordenes.service;

import com.botilleria.ordenes.model.Orden;
import com.botilleria.ordenes.config.RabbitMQConfig;
import com.botilleria.ordenes.repository.OrdenRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class OrdenService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired(required = false)
    private OrdenRepository ordenRepository;

    public Orden crearOrden(Orden orden) {
        if (orden.getId() == null) {
            orden.setId(UUID.randomUUID().toString());
        }

        // 1. Guardar en Supabase PostgreSQL
        if (ordenRepository != null) {
            try {
                ordenRepository.save(orden);
                System.out.println("Orden persistida en Supabase: " + orden.getId());
            } catch (Exception e) {
                System.err.println("Aviso conexion Supabase en ordenes: " + e.getMessage());
            }
        }
        
        // 2. Publicar evento en RabbitMQ
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orden);
        System.out.println("Orden creada y evento publicado en RabbitMQ: " + orden.getId());
        
        return orden;
    }
}
