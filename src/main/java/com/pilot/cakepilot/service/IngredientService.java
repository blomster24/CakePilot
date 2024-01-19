package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import com.pilot.cakepilot.persistence.repository.IngredientRepository;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
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
        Page<IngredientEntity> ingredientPage = this.ingredientRepository.findAll(pageRequest);

        List<IngredientDTO> ingredients = ingredientPage.getContent().stream()
                .map(IngredientDTO::new)
                .collect(Collectors.toList());
        return new PageImpl<>(ingredients, pageRequest, ingredientPage.getTotalPages());
    }

    public IngredientDTO getById(int idIngredient) {
        Optional<IngredientEntity> ingredient = this.ingredientRepository.findById(idIngredient);
        return ingredient.map(IngredientDTO::new).orElse(null);
    }

}
