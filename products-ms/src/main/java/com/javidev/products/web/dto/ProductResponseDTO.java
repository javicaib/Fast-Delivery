package com.javidev.products.web.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        String sku,
        String name,
        String description,
        BigDecimal price
) {
}
