package com.senati.cavosh_cafe.domain.entity;

public class Usuario {
    private Long id;
    private String nombre_completo;
    private String correo;
    private String contrasena;

    public Usuario(Long id, String nombre_completo, String correo, String contrasena) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
