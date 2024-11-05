package com.javidev.products.application.services;

import com.javidev.products.application.services.interfaces.MapperService;
import com.javidev.products.application.services.interfaces.ProductPersists;
import com.javidev.products.application.services.interfaces.ProductService;
import com.javidev.products.persistence.entities.ProductEntity;
import com.javidev.products.web.dto.ProductCreateDTO;
import com.javidev.products.web.dto.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceIMPL implements ProductService {
    final ProductPersists productPersists;
    final MapperService mapper;

    @Override
    public ProductResponseDTO save(@NonNull ProductCreateDTO productCreateDTO) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productCreateDTO.name());
        productEntity.setDescription(productCreateDTO.description());
        productEntity.setPrice(productCreateDTO.price());

        return mapper.productResponseDTO(productPersists.save(productEntity));
    }
}
