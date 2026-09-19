package com.senati.cavosh_cafe.presenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senati.cavosh_cafe.application.dto.IniciarSesionDTO;
import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.application.usecase.Autenticacion.IniciarSesionUseCase;
import com.senati.cavosh_cafe.application.usecase.Autenticacion.RegistrarseUseCase;
import com.senati.cavosh_cafe.presenter.mapper.AuthMapper;
import com.senati.cavosh_cafe.presenter.request.IniciarSesionRequest;
import com.senati.cavosh_cafe.presenter.request.RegistrarseRequest;
import com.senati.cavosh_cafe.presenter.response.ApiResponse;

import org.springframework.http.HttpHeaders;
import java.time.Duration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IniciarSesionUseCase iniciarSesionUseCase;
    private final RegistrarseUseCase registrarseUseCase;
    private final AuthMapper mapper;

    public AuthController(IniciarSesionUseCase iniciarSesionUseCase, RegistrarseUseCase registrarseUseCase,
            AuthMapper mapper) {
        this.iniciarSesionUseCase = iniciarSesionUseCase;
        this.registrarseUseCase = registrarseUseCase;
        this.mapper = mapper;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> iniciarSesion(@RequestBody IniciarSesionRequest request) {

        IniciarSesionDTO dto = mapper.toDto(request);

        String accessToken = iniciarSesionUseCase.execute(dto);

        ResponseCookie cookie = ResponseCookie
                .from("access_token", accessToken)
                .httpOnly(true)
                .secure(true)
                .sameSite("Lax")
                .path("/")
                .maxAge(Duration.ofHours(1))
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new ApiResponse<>(true, null, "Usuario autenticado correctamente"));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> registrarse(@RequestBody RegistrarseRequest request) {

        RegistrarseDTO dto = mapper.toDto(request);

        registrarseUseCase.execute(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, null, "Usuario registrado correctamente"));
    }

}
