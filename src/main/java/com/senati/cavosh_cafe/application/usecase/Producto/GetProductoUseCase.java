package com.senati.cavosh_cafe.application.usecase.Producto;

import com.senati.cavosh_cafe.application.dto.ProductoDTO;
import com.senati.cavosh_cafe.application.exception.ProductoNoEncontradoException;
import com.senati.cavosh_cafe.domain.entity.Producto;
import com.senati.cavosh_cafe.domain.repository.ProductoRepository;

public class GetProductoUseCase {
    
    ProductoRepository productoRepository;

    public GetProductoUseCase(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public ProductoDTO execute(Long idProducto){

        Producto producto = productoRepository.buscarPorId(idProducto).orElseThrow(() -> new ProductoNoEncontradoException());
        
        return new ProductoDTO(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio());

    }

}
