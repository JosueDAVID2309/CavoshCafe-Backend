package com.senati.cavosh_cafe.domain.repository;

import java.util.List;
import java.util.Optional;

import com.senati.cavosh_cafe.domain.entity.Producto;

public interface ProductoRepository {
    List<Producto> obtenerProductos(Long idCategoria);

    List<Producto> obtenerProductosRecientes();

    List<Producto> obtenerProductosPopulares();

    Optional<Producto> buscarPorId(Long idProducto);
}
