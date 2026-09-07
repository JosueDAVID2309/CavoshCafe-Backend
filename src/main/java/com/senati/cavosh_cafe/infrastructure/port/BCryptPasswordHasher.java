package com.senati.cavosh_cafe.infrastructure.port;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.senati.cavosh_cafe.application.port.PasswordHasher;
import com.senati.cavosh_cafe.application.port.PasswordVerifier;

@Component 
public class BCryptPasswordHasher implements PasswordVerifier, PasswordHasher{

    private final PasswordEncoder encoder;

    public BCryptPasswordHasher(PasswordEncoder encoder){
        this.encoder = encoder;
    }
    
    @Override 
    public boolean matches(String contrasenaIngresada, String contrasenaHasheada){
        return encoder.matches(contrasenaIngresada, contrasenaHasheada);
    }

    @Override 
    public String encode(String contrasena){
        return encoder.encode(contrasena);
    }

}
