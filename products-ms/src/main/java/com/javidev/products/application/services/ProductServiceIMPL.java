package com.javidev.products.application.services;

import com.javidev.products.application.services.interfaces.category.CategoryPersists;
import com.javidev.products.application.services.interfaces.category.CategoryService;
import com.javidev.products.application.services.interfaces.mapper.MapperService;
import com.javidev.products.application.services.interfaces.product.ProductPersists;
import com.javidev.products.application.services.interfaces.product.ProductService;
import com.javidev.products.persistence.entities.CategoryEntity;
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
    final CategoryService categoryService;
    final MapperService mapper;

    @Override
    public ProductResponseDTO save(@NonNull ProductCreateDTO productCreateDTO) {
        ProductEntity productEntity = new ProductEntity();

        // Si no se proporciona una categoría, asigna 'general' como valor por defecto
        String categoryName = productCreateDTO.category() != null ? productCreateDTO.category().toLowerCase() : "general";

        // Obtiene o crea la categoría y la asigna al producto antes de guardarlo
        CategoryEntity categoryEntity = categoryService.getOrCreate(categoryName);
        productEntity.setCategory(categoryEntity); // Asigna la categoría al producto

        // Asigna otros valores del producto
        productEntity.setName(productCreateDTO.name());
        productEntity.setDescription(productCreateDTO.description());
        productEntity.setPrice(productCreateDTO.price());

        // Guarda el producto en la base de datos
        ProductEntity savedProductEntity = productPersists.save(productEntity);

        // Agrega el producto a la categoría (opcional si quieres que el objeto esté sincronizado)
        categoryEntity.addProduct(savedProductEntity);

        // Convierte el producto guardado a DTO para la respuesta
        return mapper.productResponseDTO(savedProductEntity);
    }
}
