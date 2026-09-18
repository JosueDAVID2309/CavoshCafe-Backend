package com.senati.cavosh_cafe.domain.entity;

public class Crema {

    private Long idCrema;
    private String nombre;
    private Double precio;

    public Crema() {
    }

    public Crema(Long idCrema, String nombre) {
        this.idCrema = idCrema;
        this.nombre = nombre;
        this.precio = 0.0;
    }

    public Crema(Long idCrema, String nombre, Double precio) {
        this.idCrema = idCrema;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getIdCrema() {
        return idCrema;
    }

    public void setIdCrema(Long idCrema) {
        this.idCrema = idCrema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
