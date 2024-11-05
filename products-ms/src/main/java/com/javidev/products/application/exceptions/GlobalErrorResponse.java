package com.javidev.products.application.exceptions;

import java.time.Instant;
import java.util.List;

public record GlobalErrorResponse(
        String code,
        String message,
        List<String> details,
        Instant timestamp
) {
    // Constructor personalizado para asignar el timestamp automáticamente
    public GlobalErrorResponse(String code, String message, List<String> details) {
        this(code, message, details, Instant.now());
    }

    // Constructor personalizado para asignar el timestamp automáticamente y no haga falta detallar la excepcion
    public GlobalErrorResponse(String code, String message) {
        this(code, message, null, Instant.now());
    }
}