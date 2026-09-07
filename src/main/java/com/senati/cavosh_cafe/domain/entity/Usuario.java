package com.senati.cavosh_cafe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Long id;
    private String nombre_completo;
    private String correo;
    private String contrasena;
}
