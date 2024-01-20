package com.pilot.cakepilot.persistence.repository;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface IngredientRepository extends ListCrudRepository<IngredientEntity, Integer>, PagingAndSortingRepository<IngredientEntity, Integer> {

    Optional<IngredientEntity> findByNameIgnoreCase(String name);

    Page<IngredientEntity> findAllByDeletedFalse(Pageable pageable);

    Page<IngredientEntity> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
