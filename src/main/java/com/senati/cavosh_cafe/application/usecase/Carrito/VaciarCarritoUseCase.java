package com.senati.cavosh_cafe.application.usecase.Carrito;

import com.senati.cavosh_cafe.domain.repository.DetallesCarritoRepository;

public class VaciarCarritoUseCase {
    private final DetallesCarritoRepository detallesCarritoRepository;

    public VaciarCarritoUseCase(DetallesCarritoRepository detallesCarritoRepository){
        this.detallesCarritoRepository = detallesCarritoRepository;
    }

    private void execute(Long idCarrito){
        detallesCarritoRepository.vaciarCarrito(idCarrito);
    }
}
