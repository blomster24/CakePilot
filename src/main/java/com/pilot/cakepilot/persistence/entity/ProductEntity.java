package com.pilot.cakepilot.persistence.entity;

import com.pilot.cakepilot.persistence.audit.AuditableEntity;
import com.pilot.cakepilot.persistence.audit.AuditableEntityListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@EntityListeners({AuditableEntity.class, AuditableEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 250)
    private String description;

    @Column(columnDefinition = "DECIMAL(10,2)",nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "product")
    private List<ProductIngredientEntity> productIngredients;

}
