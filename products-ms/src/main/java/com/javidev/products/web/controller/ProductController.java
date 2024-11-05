package com.javidev.products.web.controller;

import com.javidev.products.application.services.interfaces.ProductService;
import com.javidev.products.web.dto.ProductCreateDTO;
import com.javidev.products.web.dto.ProductResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    final ProductService productService;

    @PostMapping("/api/v1")
    public ResponseEntity<ProductResponseDTO> save(@RequestBody @Valid ProductCreateDTO productCreateDTO) {
        return ResponseEntity.status(201).body(productService.save(productCreateDTO));
    }
}
