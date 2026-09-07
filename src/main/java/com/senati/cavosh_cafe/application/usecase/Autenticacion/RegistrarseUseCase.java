package com.senati.cavosh_cafe.application.usecase.Autenticacion;

import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.application.exception.CorreoExistenteException;
import com.senati.cavosh_cafe.application.mapper.UsuarioMapper;
import com.senati.cavosh_cafe.application.port.PasswordHasher;
import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

public class RegistrarseUseCase {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordHasher hasher;

    public RegistrarseUseCase(UsuarioRepository repository, UsuarioMapper mapper, PasswordHasher hasher){
        this.repository = repository;
        this.mapper = mapper;
        this.hasher = hasher;
    }

    public void execute(RegistrarseDTO dto){
        
        if(repository.existePorCorreo(dto.getCorreo())){
            throw new CorreoExistenteException();
        }

        dto.setContrasena(hasher.encode(dto.getContrasena()));

        Usuario usuario = mapper.toEntity(dto);

        repository.registrarUsuario(usuario);
    }
}
