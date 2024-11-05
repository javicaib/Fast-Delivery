package com.javidev.products.web.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * DTO for {@link com.javidev.products.persistence.entities.ProductEntity}
 */

public record ProductCreateDTO(
        @NotBlank(message = "The name is required and cannot be blank")
        @Size(max = 50, message = "The name cannot exceed 50 characters")
        String name,

        @Size(max = 150, message = "The description cannot exceed 150 characters")
        String description,

        @NotNull(message = "The price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "The price must be greater than 0")
        @Digits(integer = 10, fraction = 2, message = "The price cannot have more than 10 digits and 2 decimal places")
        BigDecimal price

) {
}