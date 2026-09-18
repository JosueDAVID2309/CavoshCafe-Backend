package com.senati.cavosh_cafe.domain.entity;

import java.time.LocalDate;

public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long idCategoria;
    private LocalDate added_at;

    public Producto(Long id, String nombre, String descripcion, Double precio, Long idCategoria, LocalDate added_at) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.added_at = added_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public LocalDate getAdded_at() {
        return added_at;
    }

    public void setAdded_at(LocalDate added_at) {
        this.added_at = added_at;
    }
}
