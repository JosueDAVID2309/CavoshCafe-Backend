package com.senati.cavosh_cafe.application.exception;

public class CorreoExistenteException extends RuntimeException {
    public CorreoExistenteException(){
        super("Este correo ya ha sido registrado, prueba con otro...");
    }
}
