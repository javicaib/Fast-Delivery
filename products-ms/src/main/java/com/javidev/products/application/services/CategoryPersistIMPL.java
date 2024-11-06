package com.javidev.products.application.services;

import com.javidev.products.application.services.interfaces.category.CategoryPersists;
import com.javidev.products.persistence.entities.CategoryEntity;
import com.javidev.products.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryPersistIMPL implements CategoryPersists {
    final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }
}
