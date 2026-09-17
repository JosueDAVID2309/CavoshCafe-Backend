package com.senati.cavosh_cafe.application.usecase.Producto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.senati.cavosh_cafe.application.dto.ProductoDTO;
import com.senati.cavosh_cafe.application.exception.ProductoNoEncontradoException;
import com.senati.cavosh_cafe.domain.entity.Producto;
import com.senati.cavosh_cafe.domain.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
public class GetProductoUseCaseTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private GetProductoUseCase getProductoUseCase;

    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Café Latte");
        producto.setDescripcion("Delicioso café con leche");
        producto.setPrecio(5.5);
    }

    @Test
    void execute_WhenProductoExists_ReturnsProductoDTO() {
        // Arrange
        when(productoRepository.buscarPorId(1L)).thenReturn(Optional.of(producto));

        // Act
        ProductoDTO result = getProductoUseCase.execute(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Café Latte", result.getNombre());
        assertEquals("Delicioso café con leche", result.getDescripcion());
        assertEquals(5.5, result.getPrecio());
    }

    @Test
    void execute_WhenProductoDoesNotExist_ThrowsProductoNoEncontradoException() {
        // Arrange
        when(productoRepository.buscarPorId(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ProductoNoEncontradoException.class, () -> getProductoUseCase.execute(1L));
    }
}
