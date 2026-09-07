package com.senati.cavosh_cafe.application.mapper;

import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.domain.entity.Usuario;

public class UsuarioMapper {
    public Usuario toEntity(RegistrarseDTO dto){
        Usuario usuario = new Usuario();
        usuario.setId(null);
        usuario.setNombre_completo(dto.getNombre_completo());
        usuario.setCorreo(dto.getCorreo());
        usuario.setContrasena(dto.getContrasena());

        return usuario;
    }

}
