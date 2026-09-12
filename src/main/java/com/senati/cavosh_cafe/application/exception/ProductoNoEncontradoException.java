package com.senati.cavosh_cafe.application.exception;

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(){
        super("No se encontro producto...");
    }
}
