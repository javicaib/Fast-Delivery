package com.javidev.products.application.services;

import com.javidev.products.application.services.interfaces.MapperService;
import com.javidev.products.persistence.entities.ProductEntity;
import com.javidev.products.web.dto.ProductResponseDTO;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class MapperServiceIMPL implements MapperService {
    @Override
    public ProductResponseDTO productResponseDTO(@NonNull ProductEntity productEntity) {
        return new ProductResponseDTO(
                productEntity.getSku(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice()
        );
    }
}
