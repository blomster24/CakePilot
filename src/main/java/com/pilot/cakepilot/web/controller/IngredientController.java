package com.pilot.cakepilot.web.controller;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import com.pilot.cakepilot.service.IngredientService;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAll() {
        return ResponseEntity.ok(this.ingredientService.getAll());
    }

    @GetMapping("/{idIngredient}")
    public ResponseEntity<IngredientDTO> getById(@PathVariable int idIngredient) {
        return ResponseEntity.ok(this.ingredientService.getById(idIngredient));
    }
}
