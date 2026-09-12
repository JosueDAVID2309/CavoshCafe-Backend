package com.senati.cavosh_cafe.unit.usecases;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.senati.cavosh_cafe.application.dto.ProductoDTO;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductosUseCase;
import com.senati.cavosh_cafe.domain.entity.Producto;
import com.senati.cavosh_cafe.domain.repository.ProductoRepository;

public class GetProductosUseCaseTest {

    private GetProductosUseCase useCase;
    private ProductoRepository productoRepository;

    
    @BeforeEach 
    void init(){
        productoRepository = mock(ProductoRepository.class);
        useCase = new GetProductosUseCase(productoRepository);
    }

    @Test 
    void deberiaRetornarListaUsuarios(){

        Producto producto1 = new Producto(1L, "Cafe", "Cafe fino", 20.0, 2L, LocalDate.now());
        Producto producto2 = new Producto(2L, "Capuccino", "Cafe espumoso", 18.0, 2L, LocalDate.now());
        Producto producto3 = new Producto(3L, "Expresso", "Cafe helado", 10.0, 2L, LocalDate.now());

        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        when(productoRepository.obtenerProductos(2L)).thenReturn(productos);

        List<ProductoDTO> productosDTO = useCase.execute(2L);
        ProductoDTO productoDTO = productosDTO.get(0);

        assertAll(
            () -> assertFalse(productosDTO.isEmpty()),
            () -> assertTrue(productosDTO.size() > 0),
            () -> assertEquals(1L, productoDTO.getId()),
            () -> assertEquals("Cafe", productoDTO.getNombre()),
            () -> assertEquals("Cafe fino", productoDTO.getDescripcion()),
            () -> assertEquals(20.0, productoDTO.getPrecio())
        );

    }
}
