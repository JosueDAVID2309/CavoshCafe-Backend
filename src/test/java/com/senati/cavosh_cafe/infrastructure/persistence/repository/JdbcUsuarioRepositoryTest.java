package com.senati.cavosh_cafe.infrastructure.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.senati.cavosh_cafe.domain.entity.Usuario;

@ExtendWith(MockitoExtension.class)
public class JdbcUsuarioRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private JdbcUsuarioRepository repository;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreo("test@test.com");
        usuario.setContrasena("password");
        usuario.setNombre_completo("John Doe");
    }

    @Test
    void buscarPorCorreo_WhenExists_ReturnsUsuario() {
        // Arrange
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq("test@test.com")))
                .thenReturn(usuario);

        // Act
        Optional<Usuario> result = repository.buscarPorCorreo("test@test.com");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("test@test.com", result.get().getCorreo());
    }

    @Test
    void buscarPorCorreo_WhenDoesNotExist_ReturnsEmpty() {
        // Arrange
        when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq("test@test.com")))
                .thenThrow(new EmptyResultDataAccessException(1));

        // Act
        Optional<Usuario> result = repository.buscarPorCorreo("test@test.com");

        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    void existePorCorreo_ReturnsTrue() {
        // Arrange
        when(jdbcTemplate.queryForObject(anyString(), eq(Boolean.class), eq("test@test.com")))
                .thenReturn(true);

        // Act
        boolean result = repository.existePorCorreo("test@test.com");

        // Assert
        assertTrue(result);
    }
}
