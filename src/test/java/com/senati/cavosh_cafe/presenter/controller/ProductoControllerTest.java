package com.senati.cavosh_cafe.presenter.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.senati.cavosh_cafe.application.dto.ProductoDTO;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductoUseCase;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductosPopularesUseCase;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductosRecientesUseCase;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductosUseCase;

@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GetProductosUseCase getProductosUseCase;

    @Mock
    private GetProductoUseCase getProductoUseCase;

    @Mock
    private GetProductosPopularesUseCase getProductosPopularesUseCase;

    @Mock
    private GetProductosRecientesUseCase getProductosRecientesUseCase;

    @InjectMocks
    private ProductoController productoController;

    private ProductoDTO productoDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productoController).build();

        productoDTO = new ProductoDTO();
        productoDTO.setId(1L);
        productoDTO.setNombre("Café Espresso");
        productoDTO.setDescripcion("Fuerte");
        productoDTO.setPrecio(2.5);
    }

    @Test
    void obtenerProductos_ReturnsOkAndListaProductos() throws Exception {
        // Arrange
        List<ProductoDTO> productos = Arrays.asList(productoDTO);
        when(getProductosUseCase.execute(null)).thenReturn(productos);

        // Act & Assert
        mockMvc.perform(get("/api/productos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Productos obtenidos correctamente"))
                .andExpect(jsonPath("$.data[0].id").value(1))
                .andExpect(jsonPath("$.data[0].nombre").value("Café Espresso"));
    }

    @Test
    void obtenerProducto_ReturnsOkAndProducto() throws Exception {
        // Arrange
        when(getProductoUseCase.execute(1L)).thenReturn(productoDTO);

        // Act & Assert
        mockMvc.perform(get("/api/productos/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Producto obtenido correctamente"))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.nombre").value("Café Espresso"));
    }

    @Test
    void obtenerProductosPopulares_ReturnsOkAndListaProductos() throws Exception {
        // Arrange
        List<ProductoDTO> productos = Arrays.asList(productoDTO);
        when(getProductosPopularesUseCase.execute()).thenReturn(productos);

        // Act & Assert
        mockMvc.perform(get("/api/productos/populares")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Productos obtenidos correctamente"))
                .andExpect(jsonPath("$.data[0].id").value(1));
    }

    @Test
    void obtenerProductosRecientes_ReturnsOkAndListaProductos() throws Exception {
        // Arrange
        List<ProductoDTO> productos = Arrays.asList(productoDTO);
        when(getProductosRecientesUseCase.execute()).thenReturn(productos);

        // Act & Assert
        mockMvc.perform(get("/api/productos/recientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Productos obtenidos correctamente"))
                .andExpect(jsonPath("$.data[0].id").value(1));
    }
}
