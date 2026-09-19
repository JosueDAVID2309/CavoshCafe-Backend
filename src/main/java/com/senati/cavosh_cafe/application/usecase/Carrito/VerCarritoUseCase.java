package com.senati.cavosh_cafe.application.usecase.Carrito;

import com.senati.cavosh_cafe.application.exception.CarritoNoEncontradoException;
import com.senati.cavosh_cafe.domain.entity.Carrito;
import com.senati.cavosh_cafe.domain.repository.CarritoRepository;

public class VerCarritoUseCase {

    private final CarritoRepository carritoRepository;

    public VerCarritoUseCase(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public Carrito ejecutar(Long idUsuario) {
        return carritoRepository.obtenerCarritoPorIdUsuario(idUsuario)
                .orElseThrow(() -> new CarritoNoEncontradoException());
    }
}
