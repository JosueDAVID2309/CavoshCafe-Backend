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
public class GetProductosRecientesUseCaseTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private GetProductosRecientesUseCase getProductosRecientesUseCase;

    private Producto p1;

    @BeforeEach
    void setUp() {
        p1 = new Producto();
        p1.setId(10L);
        p1.setNombre("Muffin");
        p1.setDescripcion("Recién horneado");
        p1.setPrecio(2.5);
    }

    @Test
    void execute_ReturnsListOfProductoDTOs() {
        // Arrange
        when(productoRepository.obtenerProductosRecientes()).thenReturn(Arrays.asList(p1));

        // Act
        List<ProductoDTO> result = getProductosRecientesUseCase.execute();

        // Assert
        assertEquals(1, result.size());
        assertEquals(10L, result.get(0).getId());
        assertEquals("Muffin", result.get(0).getNombre());
    }
}
