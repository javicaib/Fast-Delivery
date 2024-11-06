package com.javidev.products.application.services.interfaces.mapper;

import com.javidev.products.persistence.entities.ProductEntity;
import com.javidev.products.web.dto.ProductResponseDTO;
import io.micrometer.common.lang.NonNull;

public interface MapperService {
    ProductResponseDTO productResponseDTO(@NonNull ProductEntity productEntity);
}
