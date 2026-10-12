package com.botilleria.ordenes.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class Orden {

    @Id
    private String id;

    @Column(name = "usuario_id")
    private String usuarioId;

    private Double total;

    @Transient
    private List<OrderItem> items;

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
