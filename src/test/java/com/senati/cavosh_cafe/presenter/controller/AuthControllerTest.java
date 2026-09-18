package com.senati.cavosh_cafe.presenter.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senati.cavosh_cafe.application.dto.IniciarSesionDTO;
import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.application.usecase.Autenticacion.IniciarSesionUseCase;
import com.senati.cavosh_cafe.application.usecase.Autenticacion.RegistrarseUseCase;
import com.senati.cavosh_cafe.presenter.mapper.AuthMapper;
import com.senati.cavosh_cafe.presenter.request.IniciarSesionRequest;
import com.senati.cavosh_cafe.presenter.request.RegistrarseRequest;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IniciarSesionUseCase iniciarSesionUseCase;

    @Mock
    private RegistrarseUseCase registrarseUseCase;

    @Mock
    private AuthMapper mapper;

    @InjectMocks
    private AuthController authController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    void iniciarSesion_ReturnsOkAndCookie() throws Exception {
        // Arrange
        IniciarSesionRequest request = new IniciarSesionRequest();
        request.setCorreo("test@test.com");
        request.setContrasena("password");

        IniciarSesionDTO dto = new IniciarSesionDTO();

        when(mapper.toDto(any(IniciarSesionRequest.class))).thenReturn(dto);
        when(iniciarSesionUseCase.execute(dto)).thenReturn("fake_token");

        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(header().exists("Set-Cookie"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Usuario autenticado correctamente"));
    }

    @Test
    void registrarse_ReturnsCreated() throws Exception {
        // Arrange
        RegistrarseRequest request = new RegistrarseRequest();
        request.setCorreo("test@test.com");
        request.setContrasena("password");
        request.setNombre_completo("Test User");

        RegistrarseDTO dto = new RegistrarseDTO();

        when(mapper.toDto(any(RegistrarseRequest.class))).thenReturn(dto);
        doNothing().when(registrarseUseCase).execute(dto);

        // Act & Assert
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Usuario registrado correctamente"));
    }
}
