package com.senati.cavosh_cafe.domain.repository;

import java.util.Optional;

import com.senati.cavosh_cafe.domain.entity.Usuario;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorCorreo(String correo);

    void registrarUsuario(Usuario usuario);

    boolean existePorCorreo(String correo);
}
