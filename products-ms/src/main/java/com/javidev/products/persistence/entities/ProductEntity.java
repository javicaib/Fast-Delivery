package com.javidev.products.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long productId;

    @Column(name = "sku", unique = true, length = 50)
    String sku;

    @Column(name = "name", unique = true, nullable = false,length = 100)
    String name;

    @Column(name = "description", length = 500)
    String description;

    @Column(name = "price", precision = 10, scale = 2)
    BigDecimal price;

    @Column(name = "active")
    Boolean active;

    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        this.active = true;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();

    }
    @PostPersist
    protected void onSave() {
        this.sku = generateSKU();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    @NonNull
    private String generateSKU(){
        // Fecha de creacion
        String date = DateTimeFormatter.ofPattern("ddMMyyyy").format(createdAt.atZone(ZoneId.systemDefault()));

        // Precio
        String pricePart = price != null ? String.valueOf(price.intValue()) : "0000";

        // Tres primeras letras del nombre en mayúsculas
        String nameAbbreviation = (name != null && name.length() >= 3) ? name.substring(0, 3).toUpperCase() : "DEF";


        Long idPart = productId != null ? productId : 0L;
        Long pi = 4L;
        // Construir el SKU
        return date + "-" + pricePart + "-" + nameAbbreviation + "-" + idPart * pi;

    }

}
