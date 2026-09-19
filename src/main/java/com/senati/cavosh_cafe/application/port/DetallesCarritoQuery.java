package com.senati.cavosh_cafe.application.port;

import java.util.List;

import com.senati.cavosh_cafe.application.dto.ProductosCarritoDTO;

public interface DetallesCarritoQuery {
    List<ProductosCarritoDTO> obtenerDetallesCarrito(Long idCarrito);
}
