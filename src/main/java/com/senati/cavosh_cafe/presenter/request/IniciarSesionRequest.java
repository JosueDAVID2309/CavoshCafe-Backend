package com.senati.cavosh_cafe.presenter.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IniciarSesionRequest {
    private String correo;
    private String contrasena;

}
