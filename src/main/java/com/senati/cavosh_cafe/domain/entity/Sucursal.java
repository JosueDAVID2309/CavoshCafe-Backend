package com.senati.cavosh_cafe.domain.entity;

import java.time.LocalTime;

public class Sucursal {

    private Long idSucursal;
    private String nombre;
    private String ciudad;
    private String calle;
    private LocalTime hor_apertura;
    private LocalTime hor_cierre;

    public Sucursal() {
    }

    public Sucursal(Long idSucursal, String nombre, String ciudad, String calle,
            LocalTime hor_apertura, LocalTime hor_cierre) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calle = calle;
        this.hor_apertura = hor_apertura;
        this.hor_cierre = hor_cierre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalTime getHor_apertura() {
        return hor_apertura;
    }

    public void setHor_apertura(LocalTime hor_apertura) {
        this.hor_apertura = hor_apertura;
    }

    public LocalTime getHor_cierre() {
        return hor_cierre;
    }

    public void setHor_cierre(LocalTime hor_cierre) {
        this.hor_cierre = hor_cierre;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
