package com.javidev.products.application.exceptions;

import lombok.Getter;

@Getter
public enum GlobalErrorCatalog {

    PRODUCT_NOT_FOUND("ERROR_PRODUCT_001", "Product not found."),
    PRODUCT_INVALID("ERROR_PRODUCT_002", "Invalid product parameters."),
    PRODUCT_PERSISTENCE_DUPLICATED_ENTRY_ERROR("ERROR_PRODUCT_003", "Product already exists."),


    REQUEST_ERROR_MISSING_BODY("ERROR_REQUEST_001", "Missing request body."),
    REQUEST_ERROR_INVALID_PARAMETERS("ERROR_REQUEST_001", "Invalid parameters.."),
    GENERIC_ERROR("ERROR_GEN_001", "A catastrophic error has occurred."),
    ;

    private final String code;
    private final String message;

    /**
     * Constructor para crear un nuevo ErrorCatalog con un código y un mensaje.
     *
     * @param code    el código del error
     * @param message el mensaje descriptivo del error
     */
    GlobalErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
