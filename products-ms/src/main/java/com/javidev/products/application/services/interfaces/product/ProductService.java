package com.javidev.products.application.services.interfaces.product;

import com.javidev.products.web.dto.ProductCreateDTO;
import com.javidev.products.web.dto.ProductResponseDTO;


public interface ProductService {
    ProductResponseDTO save(ProductCreateDTO productCreateDTO);
}
