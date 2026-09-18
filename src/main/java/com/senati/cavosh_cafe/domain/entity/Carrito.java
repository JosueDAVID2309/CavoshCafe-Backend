package com.senati.cavosh_cafe.domain.entity;

public class Carrito {

    private Long idCarrito;
    private Long idUsuario;
    private Double subtotal;
    private Double descuento;

    public Carrito(Long idCarrito, Long idUsuario, Double subtotal, Double descuento) {
        this.idCarrito = idCarrito;
        this.idUsuario = idUsuario;
        this.subtotal = subtotal;
        this.descuento = descuento;
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

}
