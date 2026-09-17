package com.senati.cavosh_cafe.presenter.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.senati.cavosh_cafe.application.exception.CorreoExistenteException;
import com.senati.cavosh_cafe.application.exception.CredencialesIncorrectasException;
import com.senati.cavosh_cafe.application.exception.ProductoNoEncontradoException;
import com.senati.cavosh_cafe.presenter.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(CredencialesIncorrectasException.class)
        public ResponseEntity<ApiResponse<?>> handleCredencialesIncorrectas(
                        CredencialesIncorrectasException e) {

                return ResponseEntity
                                .status(HttpStatus.UNAUTHORIZED)
                                .body(new ApiResponse<>(
                                                false,
                                                null,
                                                e.getMessage()));
        }

        @ExceptionHandler(CorreoExistenteException.class)
        public ResponseEntity<ApiResponse<?>> handleCorreoExistente(
                        CorreoExistenteException e) {

                return ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .body(new ApiResponse<>(
                                                false,
                                                null,
                                                e.getMessage()));
        }

        @ExceptionHandler(ProductoNoEncontradoException.class)
        public ResponseEntity<ApiResponse<?>> handleProductoNoEncontrado(
                        ProductoNoEncontradoException e) {

                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(new ApiResponse<>(
                                                false,
                                                null,
                                                e.getMessage()));
        }
}
