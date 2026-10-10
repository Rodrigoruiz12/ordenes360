package com.botilleria.ordenes;

import com.botilleria.ordenes.controller.OrdenController;
import com.botilleria.ordenes.controller.OrdenController;
import com.botilleria.ordenes.model.Orden;
import com.botilleria.ordenes.service.OrdenService;
import com.botilleria.ordenes.service.OrdenService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(OrdenController.class)
public class OrdenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrdenService servicioDeOrden;

    @Test
    public void listarCatalogo_DeberiaRetornarListaDeOrdenes() throws Exception {
        Orden p1 = new Orden(1L, "Pisco Alto del Carmen 35°", 7500, 20, "https://via.placeholder.com/200");
        Mockito.when(servicioDeOrden.obtenerTodos()).thenReturn(List.of(p1));

        mockMvc.perform(get("/api/ordenes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Pisco Alto del Carmen 35°"));
    }
}