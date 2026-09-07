package com.senati.cavosh_cafe.presenter.mapper;

import com.senati.cavosh_cafe.application.dto.IniciarSesionDTO;
import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.presenter.request.IniciarSesionRequest;
import com.senati.cavosh_cafe.presenter.request.RegistrarseRequest;

public class AuthMapper {
    public IniciarSesionDTO toDto(IniciarSesionRequest request){
        IniciarSesionDTO dto = new IniciarSesionDTO();
        dto.setCorreo(request.getCorreo());
        dto.setContrasena(request.getContrasena());
        return dto;
    }

    public RegistrarseDTO toDto(RegistrarseRequest request){
        RegistrarseDTO dto = new RegistrarseDTO();
        dto.setNombre_completo(request.getNombre_completo());
        dto.setCorreo(request.getCorreo());
        dto.setContrasena(request.getContrasena());
        return dto;
    }
}
