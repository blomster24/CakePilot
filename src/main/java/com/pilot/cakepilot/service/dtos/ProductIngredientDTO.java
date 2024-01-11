package com.pilot.cakepilot.service.dtos;

import com.pilot.cakepilot.persistence.entity.ProductIngredientEntity;
import lombok.Getter;

@Getter
public class ProductIngredientDTO {

    private Integer idIngredient;
    private Integer idProduct;

    public ProductIngredientDTO(ProductIngredientEntity productIngredient) {
        this.idIngredient = productIngredient.getIdIngredient();
        this.idProduct = productIngredient.getIdProduct();
    }
}
