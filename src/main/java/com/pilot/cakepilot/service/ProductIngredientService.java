package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.ProductIngredientEntity;
import com.pilot.cakepilot.persistence.repository.ProductIngredientRepository;
import com.pilot.cakepilot.service.dtos.ProductIngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductIngredientService {

    private final ProductIngredientRepository repository;

    @Autowired
    public ProductIngredientService(ProductIngredientRepository repository) {
        this.repository = repository;
    }

    public List<ProductIngredientDTO> getAll() {
        List<ProductIngredientEntity> entities = this.repository.findAll();
        return entities.stream()
                .map(ProductIngredientDTO::new)
                .collect(Collectors.toList());
    }
}
