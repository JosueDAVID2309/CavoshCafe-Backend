package com.senati.cavosh_cafe.application.usecase.Producto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.senati.cavosh_cafe.application.dto.ProductoDTO;
import com.senati.cavosh_cafe.domain.entity.Producto;
import com.senati.cavosh_cafe.domain.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
public class GetProductosUseCaseTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private GetProductosUseCase getProductosUseCase;

    private Producto p1;
    private Producto p2;

    @BeforeEach
    void setUp() {
        p1 = new Producto();
        p1.setId(1L);
        p1.setNombre("Café Americano");
        p1.setDescripcion("Clásico");
        p1.setPrecio(3.0);

        p2 = new Producto();
        p2.setId(2L);
        p2.setNombre("Capuchino");
        p2.setDescripcion("Con espuma");
        p2.setPrecio(4.5);
    }

    @Test
    void execute_ReturnsListOfProductoDTOs() {
        // Arrange
        Long idCategoria = 1L;
        when(productoRepository.obtenerProductos(idCategoria)).thenReturn(Arrays.asList(p1, p2));

        // Act
        List<ProductoDTO> result = getProductosUseCase.execute(idCategoria);

        // Assert
        assertEquals(2, result.size());
        
        assertEquals(1L, result.get(0).getId());
        assertEquals("Café Americano", result.get(0).getNombre());
        
        assertEquals(2L, result.get(1).getId());
        assertEquals("Capuchino", result.get(1).getNombre());
    }
}
