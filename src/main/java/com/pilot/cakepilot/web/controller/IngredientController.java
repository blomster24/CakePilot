package com.pilot.cakepilot.web.controller;

import com.pilot.cakepilot.service.IngredientService;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<Page<IngredientDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int elements) {
        return ResponseEntity.ok(this.ingredientService.getAll(page, elements));
    }

    @GetMapping("/{idIngredient}")
    public ResponseEntity<IngredientDTO> getById(@PathVariable int idIngredient) {
        return ResponseEntity.ok(this.ingredientService.getById(idIngredient));
    }


}
