package com.pilot.cakepilot.service.dtos;


import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {

    private String name;
    private String supplier;
    private String unit;
    private Integer quantity;

    public IngredientDTO(IngredientEntity ingredient) {
        this.name = ingredient.getName();
        this.supplier = ingredient.getSupplier();
        this.unit = ingredient.getUnit();
        this.quantity = ingredient.getQuantity();
    }

}
