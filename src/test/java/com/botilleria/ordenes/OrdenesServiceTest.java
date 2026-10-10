package com.botilleria.ordenes;

import com.botilleria.ordenes.model.Orden;
import com.botilleria.ordenes.service.OrdenService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrdenesServiceTest {

    @Test
    public void alObtenerTodos_deberiaRetornarTresOrdenes() {
        OrdenService servicio = new OrdenService();
        List<Orden> lista = servicio.obtenerTodos();

        assertNotNull(lista);
        assertEquals(3, lista.size());
    }

    @Test
    public void alBuscarPorId_deberiaRetornarElOrdenCorrecto() {
        OrdenService servicio = new OrdenService();
        Orden orden = servicio.buscarPorId(1L);

        assertNotNull(orden);
        assertEquals("Pisco Alto del Carmen 35°", orden.getNombre());
    }
}