package com.senati.cavosh_cafe.domain.entity;

import java.util.Optional;

public class DetallesCarrito {

    private Long idDetallesCarrito;
    private Long idCarrito;
    private Long idProducto;
    private Integer cantidad;
    private Leche leche;
    private Crema crema;
    private boolean conCafeina;
    private Long idSucursal;

    public DetallesCarrito(Long idDetallesCarrito, Long idCarrito, Long idProducto, Integer cantidad,
            Leche leche, Crema crema, boolean conCafeina, Long idSucursal) {
        this.idDetallesCarrito = idDetallesCarrito;
        this.idCarrito = idCarrito;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.leche = leche;
        this.crema = crema;
        this.conCafeina = conCafeina;
        this.idSucursal = idSucursal;
    }

    public DetallesCarrito() {
    }

    public Long getIdDetallesCarrito() {
        return idDetallesCarrito;
    }

    public void setIdDetallesCarrito(Long idDetallesCarrito) {
        this.idDetallesCarrito = idDetallesCarrito;
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Leche getLeche() {
        return leche;
    }

    public void setLeche(Leche leche) {
        this.leche = leche;
    }

    public Crema getCrema() {
        return crema;
    }

    public void setCrema(Crema crema) {
        this.crema = crema;
    }

    public boolean getConCafeina() {
        return conCafeina;
    }

    public void setConCafeina(boolean conCafeina) {
        this.conCafeina = conCafeina;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

}
