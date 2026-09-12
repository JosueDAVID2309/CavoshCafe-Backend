package com.senati.cavosh_cafe.domain.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long idCategoria;
    private LocalDate added_at;
}
