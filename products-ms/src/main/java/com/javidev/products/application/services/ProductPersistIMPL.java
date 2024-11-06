package com.javidev.products.application.services;

import com.javidev.products.application.services.interfaces.product.ProductPersists;
import com.javidev.products.application.services.interfaces.product.ProductValidations;
import com.javidev.products.persistence.entities.ProductEntity;
import com.javidev.products.persistence.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPersistIMPL implements ProductPersists {

    final ProductRepository productRepository;
    final ProductValidations productValidations;

    @Override
    public ProductEntity save(@NonNull ProductEntity product) {
        productValidations.productExistsAndThrow(product.getName());
        return productRepository.save(product);
    }

}
