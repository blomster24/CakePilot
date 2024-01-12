package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import com.pilot.cakepilot.persistence.repository.IngredientRepository;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<IngredientDTO> getAll() {
        List<IngredientEntity> ingredients = this.ingredientRepository.findAll();
        return ingredients.stream()
                .map(IngredientDTO::new)
                .collect(Collectors.toList());
    }

    public IngredientDTO getById(int idIngredient) {
        Optional<IngredientEntity> ingredient = this.ingredientRepository.findById(idIngredient);
        return ingredient.map(IngredientDTO::new).orElse(null);
    }

}
