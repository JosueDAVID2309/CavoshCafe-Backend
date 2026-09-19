package com.senati.cavosh_cafe.application.dto;

public class ProductosCarritoDTO {
    private String nombre_producto;
    private String detalles_producto;
    private int cantidad;
    private Double precio;

    public ProductosCarritoDTO(String nombre_producto, String detalles_producto, int cantidad, Double precio) {
        this.nombre_producto = nombre_producto;
        this.detalles_producto = detalles_producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDetalles_producto() {
        return detalles_producto;
    }

    public void setDetalles_producto(String detalles_producto) {
        this.detalles_producto = detalles_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
