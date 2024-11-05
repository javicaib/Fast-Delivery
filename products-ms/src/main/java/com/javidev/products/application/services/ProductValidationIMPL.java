package com.javidev.products.application.services;

import com.javidev.products.application.exceptions.domain.ProductAlreadyExists;
import com.javidev.products.application.services.interfaces.ProductValidations;
import com.javidev.products.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductValidationIMPL implements ProductValidations {
    final ProductRepository productRepository;

    @Override
    public void productExistsAndThrow(String productName) {
        if(productRepository.existsByName(productName)) throw new ProductAlreadyExists(productName);
    }
}
