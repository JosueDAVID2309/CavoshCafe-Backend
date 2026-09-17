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
public class GetProductosPopularesUseCaseTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private GetProductosPopularesUseCase getProductosPopularesUseCase;

    private Producto p1;

    @BeforeEach
    void setUp() {
        p1 = new Producto();
        p1.setId(5L);
        p1.setNombre("Frappuccino");
        p1.setDescripcion("Refrescante");
        p1.setPrecio(6.0);
    }

    @Test
    void execute_ReturnsListOfProductoDTOs() {
        // Arrange
        when(productoRepository.obtenerProductosPopulares()).thenReturn(Arrays.asList(p1));

        // Act
        List<ProductoDTO> result = getProductosPopularesUseCase.execute();

        // Assert
        assertEquals(1, result.size());
        assertEquals(5L, result.get(0).getId());
        assertEquals("Frappuccino", result.get(0).getNombre());
    }
}
