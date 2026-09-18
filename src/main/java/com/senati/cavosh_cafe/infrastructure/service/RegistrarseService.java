package com.senati.cavosh_cafe.infrastructure.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.application.usecase.Autenticacion.RegistrarseUseCase;

@Service
public class RegistrarseService {

    private final RegistrarseUseCase registrarseUseCase;

    public RegistrarseService(RegistrarseUseCase registrarseUseCase) {
        this.registrarseUseCase = registrarseUseCase;
    }

    @Transactional
    public void execute(RegistrarseDTO dto) {

        registrarseUseCase.execute(dto);
    }
}
