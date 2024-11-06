package com.javidev.products.application.services.interfaces.category;

import com.javidev.products.persistence.entities.CategoryEntity;

public interface CategoryService {
    CategoryEntity getOrCreate(String categoryName);
}
