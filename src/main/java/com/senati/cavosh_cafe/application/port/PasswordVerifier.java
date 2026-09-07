package com.senati.cavosh_cafe.application.port;

public interface PasswordVerifier {
    boolean matches(String contrasenaIngresada, String contrasenaHasheada);
}
