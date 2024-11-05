package com.javidev.products.application.services.interfaces;

import com.javidev.products.persistence.entities.ProductEntity;


public interface ProductPersists {
    ProductEntity save(ProductEntity product);
}
