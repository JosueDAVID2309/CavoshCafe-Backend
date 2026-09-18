package com.senati.cavosh_cafe.domain.repository;

import java.util.Optional;

import com.senati.cavosh_cafe.domain.entity.Carrito;

public interface CarritoRepository {
    void crearCarrito(Long idUsuario);

    Optional<Carrito> obtenerCarritoPorIdUsuario(Long idUsuario);
}
