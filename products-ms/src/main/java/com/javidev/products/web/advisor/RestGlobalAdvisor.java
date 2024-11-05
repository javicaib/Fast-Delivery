package com.javidev.products.web.advisor;

import com.javidev.products.application.exceptions.GlobalErrorResponse;
import com.javidev.products.application.exceptions.domain.ProductAlreadyExists;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static com.javidev.products.application.exceptions.GlobalErrorCatalog.*;

@RestControllerAdvice
public class RestGlobalAdvisor {
    // PRODUCT EXCEPTIONS
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ProductAlreadyExists.class)
    public GlobalErrorResponse handleProductAlreadyRegisteredException(@NonNull ProductAlreadyExists exception) {

        return new GlobalErrorResponse(
                PRODUCT_PERSISTENCE_DUPLICATED_ENTRY_ERROR.getCode(),
                PRODUCT_PERSISTENCE_DUPLICATED_ENTRY_ERROR.getMessage(),
                List.of(exception.getMessage())

        );
    }

    // GLOBAL EXCEPTIONS
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GlobalErrorResponse handleMethodArgumentNotValidException(@NonNull MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return new GlobalErrorResponse(
                REQUEST_ERROR_INVALID_PARAMETERS.getCode(),
                REQUEST_ERROR_INVALID_PARAMETERS.getMessage(),
                bindingResult.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public GlobalErrorResponse handleHttpMessageNotReadableExceptionException() {

        return new GlobalErrorResponse(
                REQUEST_ERROR_MISSING_BODY.getCode(),
                REQUEST_ERROR_MISSING_BODY.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public GlobalErrorResponse handleGenericExceptions(@NonNull Exception exception) {
        return new GlobalErrorResponse(
                GENERIC_ERROR.getCode(),
                GENERIC_ERROR.getMessage(),
                List.of(exception.getMessage())
        );
    }
}
