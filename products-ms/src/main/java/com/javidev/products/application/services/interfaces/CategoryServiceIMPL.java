package com.javidev.products.application.services.interfaces;

import com.javidev.products.application.services.interfaces.category.CategoryService;
import com.javidev.products.persistence.entities.CategoryEntity;
import com.javidev.products.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceIMPL implements CategoryService {
    final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity getOrCreate(String categoryName) {
        // Busca la categoría por nombre
        return categoryRepository.findByName(categoryName)
                .orElseGet(() -> {
                    // Si no existe, crea una nueva categoría
                    CategoryEntity newCategory = new CategoryEntity();
                    newCategory.setName(categoryName);
                    return categoryRepository.save(newCategory);
                });
    }
}
