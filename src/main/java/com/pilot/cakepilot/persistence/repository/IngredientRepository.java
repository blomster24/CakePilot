package com.pilot.cakepilot.persistence.repository;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IngredientRepository extends ListCrudRepository<IngredientEntity, Integer>, PagingAndSortingRepository<IngredientEntity, Integer> {

}
