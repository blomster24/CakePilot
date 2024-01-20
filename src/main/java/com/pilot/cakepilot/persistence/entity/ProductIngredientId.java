package com.pilot.cakepilot.persistence.entity;

import com.pilot.cakepilot.persistence.audit.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductIngredientId extends AuditableEntity {

    private Integer idProduct;

    private Integer idIngredient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductIngredientId that = (ProductIngredientId) o;
        return Objects.equals(idProduct, that.idProduct) && Objects.equals(idIngredient, that.idIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idIngredient);
    }
}
