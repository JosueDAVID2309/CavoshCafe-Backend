package com.senati.cavosh_cafe.unit.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.*;

import com.senati.cavosh_cafe.application.dto.IniciarSesionDTO;
import com.senati.cavosh_cafe.application.exception.CredencialesIncorrectasException;
import com.senati.cavosh_cafe.application.port.PasswordVerifier;
import com.senati.cavosh_cafe.application.port.TokenGenerator;
import com.senati.cavosh_cafe.application.usecase.Autenticacion.IniciarSesionUseCase;
import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

public class IniciarSesionUseCaseTest {

    private UsuarioRepository repository;
    private PasswordVerifier passwordVerifier;
    private TokenGenerator tokenGenerator;

    private IniciarSesionUseCase useCase;

    @BeforeEach
    void init() {
        repository = mock(UsuarioRepository.class);
        passwordVerifier = mock(PasswordVerifier.class);
        tokenGenerator = mock(TokenGenerator.class);

        useCase = new IniciarSesionUseCase(repository, passwordVerifier, tokenGenerator);
    }

    @Test
    void deberiaIniciarSesionCorrectamente() {
        Usuario usuario = new Usuario(
                1L,
                "Josue",
                "josue@gmail.com",
                "HASH");

        IniciarSesionDTO dto = new IniciarSesionDTO(
                "josue@gmail.com",
                "123456");

        when(repository.buscarPorCorreo("josue@gmail.com")).thenReturn(Optional.of(usuario));
        when(passwordVerifier.matches("123456", "HASH")).thenReturn(true);
        when(tokenGenerator.generateToken("josue@gmail.com")).thenReturn("jwt-falso");

        String token = useCase.execute(dto);

        assertEquals("jwt-falso", token);

    }

    @Test
    void deberiaLanzarExcepcionCuandoUsuarioNoExiste() {

        IniciarSesionDTO dto = new IniciarSesionDTO(
                "noexiste@gmail.com",
                "123456");

        when(repository.buscarPorCorreo("noexiste@gmail.com"))
                .thenReturn(Optional.empty());

        assertThrows(
                CredencialesIncorrectasException.class,
                () -> useCase.execute(dto));
    }

    @Test
    void deberiaLanzarExcepcionCuandoLaContrasenaEsIncorrecta() {

        Usuario usuario = new Usuario(
                1L,
                "Josue",
                "josue@gmail.com",
                "HASH");

        IniciarSesionDTO dto = new IniciarSesionDTO(
                "josue@gmail.com",
                "contraseña-incorrecta");

        when(repository.buscarPorCorreo("josue@gmail.com"))
                .thenReturn(Optional.of(usuario));

        when(passwordVerifier.matches(
                "contraseña-incorrecta",
                "HASH"))
                .thenReturn(false);

        assertThrows(
                CredencialesIncorrectasException.class,
                () -> useCase.execute(dto));
    }

}
