package com.senati.cavosh_cafe.application.usecase.Autenticacion;

import com.senati.cavosh_cafe.application.exception.CredencialesIncorrectasException;
import com.senati.cavosh_cafe.application.port.PasswordVerifier;
import com.senati.cavosh_cafe.application.port.TokenGenerator;
import com.senati.cavosh_cafe.application.dto.IniciarSesionDTO;
import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

public class IniciarSesionUseCase {

    private final UsuarioRepository repository;
    private final PasswordVerifier passwordVerifier;
    private final TokenGenerator tokenGenerator;

    public IniciarSesionUseCase(
            UsuarioRepository repository,
            PasswordVerifier passwordVerifier,
            TokenGenerator tokenGenerator) {

        this.repository = repository;
        this.passwordVerifier = passwordVerifier;
        this.tokenGenerator = tokenGenerator;
    }

    public String execute(IniciarSesionDTO dto) {

        Usuario usuario = repository
                .buscarPorCorreo(dto.getCorreo())
                .orElseThrow(() -> new CredencialesIncorrectasException());

        if (!passwordVerifier.matches(
                dto.getContrasena(),
                usuario.getContrasena())) {

            throw new CredencialesIncorrectasException();
        }

        return tokenGenerator.generateToken(usuario.getCorreo());
    }

}
