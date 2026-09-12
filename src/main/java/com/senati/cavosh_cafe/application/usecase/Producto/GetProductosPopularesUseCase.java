package com.senati.cavosh_cafe.application.usecase.Producto;

import java.util.ArrayList;
import java.util.List;

import com.senati.cavosh_cafe.application.dto.ProductoDTO;
import com.senati.cavosh_cafe.domain.entity.Producto;
import com.senati.cavosh_cafe.domain.repository.ProductoRepository;

public class GetProductosPopularesUseCase {
    ProductoRepository productoRepository;

    public GetProductosPopularesUseCase(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> execute(){
        List<Producto> productos = productoRepository.obtenerProductosPopulares();

        List<ProductoDTO> productosdto = new ArrayList<ProductoDTO>();

        for(Producto producto : productos){
            productosdto.add(new ProductoDTO(producto.getId() ,producto.getNombre(), producto.getDescripcion(), producto.getPrecio()));
        }

        return productosdto;
    }
}
