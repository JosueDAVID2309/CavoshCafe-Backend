package com.senati.cavosh_cafe.domain.entity;

public class Leche {
    private Long idLeche;
    private String nombre;
    private Double precio;

    public Leche() {
    }

    public Leche(Long idLeche, String nombre) {
        this.idLeche = idLeche;
        this.nombre = nombre;
        this.precio = 0.0;
    }

    public Leche(Long idLeche, String nombre, Double precio) {
        this.idLeche = idLeche;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getIdLeche() {
        return idLeche;
    }

    public void setIdLeche(Long idLeche) {
        this.idLeche = idLeche;
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
