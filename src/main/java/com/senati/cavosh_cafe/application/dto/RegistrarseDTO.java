package com.senati.cavosh_cafe.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarseDTO {
    private String nombre_completo;
    private String correo;
    private String contrasena;
}
