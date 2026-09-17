package com.senati.cavosh_cafe.presenter.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senati.cavosh_cafe.application.dto.ProductoDTO;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductoUseCase;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductosPopularesUseCase;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductosRecientesUseCase;
import com.senati.cavosh_cafe.application.usecase.Producto.GetProductosUseCase;
import com.senati.cavosh_cafe.presenter.response.ApiResponse;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final GetProductosUseCase getProductosUseCase;
    private final GetProductoUseCase getProductoUseCase;
    private final GetProductosPopularesUseCase getProductosPopularesUseCase;
    private final GetProductosRecientesUseCase getProductosRecientesUseCase;

    public ProductoController(GetProductosUseCase getProductosUseCase, GetProductoUseCase getProductoUseCase,
            GetProductosPopularesUseCase getProductosPopularesUseCase,
            GetProductosRecientesUseCase getProductosRecientesUseCase) {
        this.getProductosUseCase = getProductosUseCase;
        this.getProductoUseCase = getProductoUseCase;
        this.getProductosPopularesUseCase = getProductosPopularesUseCase;
        this.getProductosRecientesUseCase = getProductosRecientesUseCase;
    }

    @GetMapping({"", "/categoria/{idCategoria}"})
    public ResponseEntity<ApiResponse<?>> obtenerProductos(@PathVariable(required = false) Long idCategoria) {

        List<ProductoDTO> productos = getProductosUseCase.execute(idCategoria);

        return ResponseEntity.ok()
                .body(new ApiResponse<>(true, productos, "Productos obtenidos correctamente"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> obtenerProducto(@PathVariable Long id) {

        ProductoDTO producto = getProductoUseCase.execute(id);

        return ResponseEntity.ok()
                .body(new ApiResponse<>(true, producto, "Producto obtenido correctamente"));
    }

    @GetMapping("/populares")
    public ResponseEntity<ApiResponse<?>> obtenerProductosPopulares() {

        List<ProductoDTO> productos = getProductosPopularesUseCase.execute();

        return ResponseEntity.ok()
                .body(new ApiResponse<>(true, productos, "Productos obtenidos correctamente"));
    }

    @GetMapping("/recientes")
    public ResponseEntity<ApiResponse<?>> obtenerProductosRecientes() {

        List<ProductoDTO> productos = getProductosRecientesUseCase.execute();

        return ResponseEntity.ok()
                .body(new ApiResponse<>(true, productos, "Productos obtenidos correctamente"));
    }

}
