package com.senati.cavosh_cafe.application.usecase.Carrito;

import java.util.List;

import com.senati.cavosh_cafe.application.dto.ProductosCarritoDTO;
import com.senati.cavosh_cafe.application.port.DetallesCarritoQuery;

public class VerCarritoUseCase {

    private final DetallesCarritoQuery detallesCarritoQuery;

    public VerCarritoUseCase(final DetallesCarritoQuery detallesCarritoQuery){
        this.detallesCarritoQuery = detallesCarritoQuery;
    }

    public List<ProductosCarritoDTO> execute(Long idCarrito){
        return detallesCarritoQuery.obtenerDetallesCarrito(idCarrito);
    }
}
