package com.senati.cavosh_cafe.presenter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T> {
    private boolean success;
    private T data;
    private String message;
}
