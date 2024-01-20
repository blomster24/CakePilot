package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import com.pilot.cakepilot.persistence.repository.IngredientRepository;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
import com.pilot.cakepilot.service.exceptions.IngredientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<IngredientDTO> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        Page<IngredientEntity> ingredientPage = this.ingredientRepository.findAllByDeletedFalse(pageRequest);

        List<IngredientDTO> ingredients = ingredientPage.getContent().stream()
                .map(IngredientDTO::new)
                .collect(Collectors.toList());
        return new PageImpl<>(ingredients, pageRequest, ingredientPage.getTotalPages());
    }

    public Page<IngredientDTO> getAllByName(int page, int elements, String name) {
        Pageable pageRequest = PageRequest.of(page, elements);
        Page<IngredientEntity> ingredientPage = this.ingredientRepository.findAllByNameContainingIgnoreCase(name, pageRequest);

        List<IngredientDTO> ingredients = ingredientPage.getContent().stream()
                .map(IngredientDTO::new)
                .collect(Collectors.toList());
        return new PageImpl<>(ingredients, pageRequest, ingredientPage.getTotalPages());
    }

    public IngredientDTO getById(int idIngredient) {
        Optional<IngredientEntity> ingredient = this.ingredientRepository.findById(idIngredient);
        return ingredient.map(IngredientDTO::new).orElse(null);
    }

    public IngredientDTO getByName(String name) {
        Optional<IngredientEntity> ingredient = this.ingredientRepository.findByNameIgnoreCase(name);
        return ingredient.map(IngredientDTO::new).orElse(null);
    }

    public IngredientEntity save(IngredientEntity newIngredient) {
        if (newIngredient.getDeleted() == null) {
            newIngredient.setDeleted(false);
        }
        return this.ingredientRepository.save(newIngredient);
    }

    public IngredientEntity update(IngredientEntity newIngredient) {
        return this.ingredientRepository.save(newIngredient);
    }

    public IngredientEntity delete(int idIngredient) {
        try {
            Optional<IngredientEntity> ingredientFounded = this.ingredientRepository.findById(idIngredient);
            if (ingredientFounded.isPresent()) {
                IngredientEntity ingredient = ingredientFounded.get();
                ingredient.setDeleted(true);
                this.ingredientRepository.save(ingredient);
                return ingredient;
            } else {
                throw new IngredientNotFoundException("Ingrediente no encontrado");
            }
        } catch (IngredientNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}
