package com.senati.cavosh_cafe.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;
import com.senati.cavosh_cafe.infrastructure.persistence.repository.JdbcUsuarioRepository;

@Configuration 
public class RepositoryConfig {
    
    @Bean 
    public UsuarioRepository usuarioRepository(JdbcTemplate jdbcTemplate){
        return new JdbcUsuarioRepository(jdbcTemplate);
    }

    
}
