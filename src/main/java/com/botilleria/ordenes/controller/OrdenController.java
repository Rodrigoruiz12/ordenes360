package com.botilleria.ordenes.controller;

import com.botilleria.ordenes.model.Orden;
import com.botilleria.ordenes.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping("/nueva")
    public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden) {
        Orden nuevaOrden = ordenService.crearOrden(orden);
        return ResponseEntity.ok(nuevaOrden);
    }
}