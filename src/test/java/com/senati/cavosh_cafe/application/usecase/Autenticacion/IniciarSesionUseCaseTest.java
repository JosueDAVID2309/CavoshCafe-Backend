package com.senati.cavosh_cafe.application.usecase.Autenticacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.senati.cavosh_cafe.application.dto.IniciarSesionDTO;
import com.senati.cavosh_cafe.application.exception.CredencialesIncorrectasException;
import com.senati.cavosh_cafe.application.port.PasswordVerifier;
import com.senati.cavosh_cafe.application.port.TokenGenerator;
import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class IniciarSesionUseCaseTest {

    @Mock
    private UsuarioRepository repository;

    @Mock
    private PasswordVerifier passwordVerifier;

    @Mock
    private TokenGenerator tokenGenerator;

    @InjectMocks
    private IniciarSesionUseCase iniciarSesionUseCase;

    private IniciarSesionDTO dto;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        dto = new IniciarSesionDTO();
        dto.setCorreo("test@test.com");
        dto.setContrasena("password");

        usuario = new Usuario();
        usuario.setCorreo("test@test.com");
        usuario.setContrasena("encoded_password");
    }

    @Test
    void execute_WhenUsuarioNotFound_ThrowsCredencialesIncorrectasException() {
        // Arrange
        when(repository.buscarPorCorreo(dto.getCorreo())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(CredencialesIncorrectasException.class, () -> iniciarSesionUseCase.execute(dto));
        
        verify(passwordVerifier, never()).matches(anyString(), anyString());
        verify(tokenGenerator, never()).generateToken(anyString());
    }

    @Test
    void execute_WhenPasswordIncorrect_ThrowsCredencialesIncorrectasException() {
        // Arrange
        when(repository.buscarPorCorreo(dto.getCorreo())).thenReturn(Optional.of(usuario));
        when(passwordVerifier.matches(dto.getContrasena(), usuario.getContrasena())).thenReturn(false);

        // Act & Assert
        assertThrows(CredencialesIncorrectasException.class, () -> iniciarSesionUseCase.execute(dto));
        
        verify(tokenGenerator, never()).generateToken(anyString());
    }

    @Test
    void execute_WhenCredentialsCorrect_ReturnsToken() {
        // Arrange
        when(repository.buscarPorCorreo(dto.getCorreo())).thenReturn(Optional.of(usuario));
        when(passwordVerifier.matches(dto.getContrasena(), usuario.getContrasena())).thenReturn(true);
        when(tokenGenerator.generateToken(usuario.getCorreo())).thenReturn("dummy_token");

        // Act
        String result = iniciarSesionUseCase.execute(dto);

        // Assert
        assertEquals("dummy_token", result);
        verify(tokenGenerator).generateToken(usuario.getCorreo());
    }
}
