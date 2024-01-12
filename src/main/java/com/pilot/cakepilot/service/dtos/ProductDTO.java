package com.pilot.cakepilot.service.dtos;

import com.pilot.cakepilot.persistence.entity.ProductEntity;
import com.pilot.cakepilot.persistence.entity.ProductIngredientEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductDTO {

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    
    //private List<IngredientDTO> ingredients;

    public ProductDTO(ProductEntity product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        //this.ingredients = convertIngredients(product.getProductIngredients());
    }

    private List<IngredientDTO> convertIngredients(List<ProductIngredientEntity> productIngredients) {
        return productIngredients.stream()
                .map(productIngredient -> new IngredientDTO(productIngredient.getIngredient()))
                .collect(Collectors.toList());
    }
}
