package com.botilleria.ordenes.model;

public class OrderItem {
    private Long productoId;
    private Integer cantidad;

    public OrderItem() {}

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}
