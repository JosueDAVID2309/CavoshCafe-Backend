package com.senati.cavosh_cafe.domain.entity;

public class DetallesCarrito {

    private Long idDetallesCarrito;
    private Long idCarrito;
    private Long idProducto;
    private Integer cantidad;
    private Long idLeche;
    private Long idCrema;
    private boolean conCafeina;
    private Long idSucursal;

    public DetallesCarrito(Long idDetallesCarrito, Long idCarrito, Long idProducto, Integer cantidad,
            Long idLeche, Long idCrema, boolean conCafeina, Long idSucursal) {
        this.idDetallesCarrito = idDetallesCarrito;
        this.idCarrito = idCarrito;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.idLeche = idLeche;
        this.idCrema = idCrema;
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

    public Long getIdLeche() {
        return idLeche;
    }

    public void setIdLeche(Long idLeche) {
        this.idLeche = idLeche;
    }

    public Long getIdCrema() {
        return idCrema;
    }

    public void setIdCrema(Long idCrema) {
        this.idCrema = idCrema;
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
