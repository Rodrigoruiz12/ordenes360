package com.botilleria.ordenes.model;

import java.util.List;

public class Orden {
    private String id;
    private String usuarioId;
    private List<OrderItem> items;
    private Double total;

    public Orden() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
