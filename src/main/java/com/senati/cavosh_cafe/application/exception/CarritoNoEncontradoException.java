package com.senati.cavosh_cafe.application.exception;

public class CarritoNoEncontradoException extends RuntimeException {
    public CarritoNoEncontradoException() {
        super("El usuario no tiene un carrito activo.");
    }
}
