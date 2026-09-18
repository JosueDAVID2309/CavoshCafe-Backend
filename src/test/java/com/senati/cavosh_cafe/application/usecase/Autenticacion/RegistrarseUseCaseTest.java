package com.senati.cavosh_cafe.application.usecase.Autenticacion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.application.exception.CorreoExistenteException;
import com.senati.cavosh_cafe.application.mapper.UsuarioMapper;
import com.senati.cavosh_cafe.application.port.PasswordHasher;
import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.CarritoRepository;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class RegistrarseUseCaseTest {

    @Mock
    private UsuarioRepository repository;

    @Mock
    private CarritoRepository carritoRepository;

    @Mock
    private UsuarioMapper mapper;

    @Mock
    private PasswordHasher hasher;

    @InjectMocks
    private RegistrarseUseCase registrarseUseCase;

    private RegistrarseDTO registrarseDTO;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        registrarseDTO = new RegistrarseDTO();
        registrarseDTO.setCorreo("test@test.com");
        registrarseDTO.setContrasena("password123");

        usuario = new Usuario();
        usuario.setCorreo("test@test.com");
        usuario.setContrasena("encoded_password");
    }

    @Test
    void execute_WhenCorreoExiste_ThrowsCorreoExistenteException() {
        // Arrange
        when(repository.existePorCorreo(registrarseDTO.getCorreo())).thenReturn(true);

        // Act & Assert
        assertThrows(CorreoExistenteException.class, () -> registrarseUseCase.execute(registrarseDTO));
        
        verify(repository, never()).registrarUsuario(any());
        verify(hasher, never()).encode(any());
    }

    @Test
    void execute_WhenValido_EncodesPasswordAndSavesUsuario() {
        // Arrange
        when(repository.existePorCorreo(registrarseDTO.getCorreo())).thenReturn(false);
        when(hasher.encode("password123")).thenReturn("encoded_password");
        when(mapper.toEntity(registrarseDTO)).thenReturn(usuario);
        when(repository.registrarUsuario(usuario)).thenReturn(1L);

        // Act
        registrarseUseCase.execute(registrarseDTO);

        // Assert
        assertEquals("encoded_password", registrarseDTO.getContrasena());
        verify(repository).registrarUsuario(usuario);
        verify(carritoRepository).crearCarrito(1L);
        verify(hasher).encode("password123");
        verify(mapper).toEntity(registrarseDTO);
    }
}
