package com.javidev.products.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "name", unique = true, nullable = false,length = 20)
    String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<ProductEntity> products = new HashSet<>();

    public void addProduct(ProductEntity product) {
        products.add(product);
        product.setCategory(this);
    }

    public void removeProduct(ProductEntity product) {
        products.remove(product);
        product.setCategory(null);
    }

}
