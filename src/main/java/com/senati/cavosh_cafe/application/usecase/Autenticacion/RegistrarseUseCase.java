package com.senati.cavosh_cafe.application.usecase.Autenticacion;

import com.senati.cavosh_cafe.application.dto.RegistrarseDTO;
import com.senati.cavosh_cafe.application.exception.CorreoExistenteException;
import com.senati.cavosh_cafe.application.mapper.UsuarioMapper;
import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

public class RegistrarseUseCase {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public RegistrarseUseCase(UsuarioRepository repository, UsuarioMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public void execute(RegistrarseDTO dto){
        
        if(repository.existePorCorreo(dto.getCorreo())){
            throw new CorreoExistenteException();
        }

        Usuario usuario = mapper.toEntity(dto);

        repository.registrarUsuario(usuario);
    }
}
