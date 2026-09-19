package com.senati.cavosh_cafe.domain.repository;

import java.util.List;
import com.senati.cavosh_cafe.domain.entity.DetallesCarrito;

public interface DetallesCarritoRepository {
    List<DetallesCarrito> obtenerDetallesCarrito(Long idCarrito);

    void vaciarCarrito(Long idCarrito);

    void agregarProducto(DetallesCarrito detallesCarrito);

    void eliminarProducto(Long idDetallesCarrito, Long idCarrito, Long idProducto);
}
