package com.senati.cavosh_cafe.application.port;

public interface TokenGenerator {
    public String generateToken(String correo);

    public String extractUsername(String token);
}
