package com.senati.cavosh_cafe.unit.usecases;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;

import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.application.exception.CorreoExistenteException;
import com.senati.cavosh_cafe.application.mapper.UsuarioMapper;
import com.senati.cavosh_cafe.application.usecase.Autenticacion.RegistrarseUseCase;
import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

public class RegistrarseUseCaseTest {

    private UsuarioRepository repository;
    private UsuarioMapper mapper;
    private RegistrarseUseCase useCase;

    @BeforeEach
    void init() {
        repository = mock(UsuarioRepository.class);
        mapper = mock(UsuarioMapper.class);
        useCase = new RegistrarseUseCase(repository, mapper);
    }

    @Test
    void deberiaRegistrarUsuarioCorrectamente() {

        RegistrarseDTO dto = new RegistrarseDTO(
                "Josue",
                "josue@gmail.com",
                "123456");

        Usuario usuario = new Usuario(
                null,
                "Josue",
                "josue@gmail.com",
                "123456");

        when(repository.existePorCorreo("josue@gmail.com"))
                .thenReturn(false);

        when(mapper.toEntity(dto))
                .thenReturn(usuario);

        useCase.execute(dto);

        verify(repository).registrarUsuario(usuario);
    }

    @Test 
    void deberiaLanzarExcepcionCuandoCorreoRegistrado(){
        RegistrarseDTO dto = new RegistrarseDTO(
                "Josue",
                "correo.registrado@gmail.com",
                "123456");

        when(repository.existePorCorreo("correo.registrado@gmail.com")).thenReturn(true);

        assertThrows(CorreoExistenteException.class, () -> useCase.execute(dto));
    }
}
