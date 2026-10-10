package com.botilleria.ordenes.controller;


import com.botilleria.ordenes.model.Orden;
import com.botilleria.ordenes.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService servicioDeOrden;

    @GetMapping
    public ResponseEntity<List<Orden>> listarCatalogo() {
        return ResponseEntity.ok(servicioDeOrden.obtenerTodos());
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<Orden> obtenerDetalle(@PathVariable Long identificador) {
        Orden ordenEncontrado = servicioDeOrden.buscarPorId(identificador);
        if (ordenEncontrado != null) {
            return ResponseEntity.ok(ordenEncontrado);
        }
        return ResponseEntity.notFound().build();
    }
}