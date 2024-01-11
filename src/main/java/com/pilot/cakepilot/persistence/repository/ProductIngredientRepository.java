package com.pilot.cakepilot.persistence.repository;

import com.pilot.cakepilot.persistence.entity.ProductIngredientEntity;
import com.pilot.cakepilot.persistence.entity.ProductIngredientId;
import com.pilot.cakepilot.service.dtos.ProductIngredientDTO;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductIngredientRepository extends ListCrudRepository<ProductIngredientEntity, ProductIngredientId> {

}
