package com.pilot.cakepilot.persistence.entity;

import com.pilot.cakepilot.persistence.audti.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_ingredients")
@IdClass(ProductIngredientId.class)
@Getter
@Setter
@NoArgsConstructor
public class ProductIngredientEntity extends AuditableEntity {

    @Id
    @Column(name = "id_ingredient", nullable = false)
    private Integer idIngredient;

    @Id
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredient", referencedColumnName = "id_ingredient", insertable = false, updatable = false)
    private IngredientEntity ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
    private ProductEntity product;

}
