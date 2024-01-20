package com.pilot.cakepilot.web.controller;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
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

    @GetMapping("/all-name/{name}")
    public ResponseEntity<Page<IngredientDTO>> getAllByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int elements,
            @PathVariable String name) {
        return ResponseEntity.ok(this.ingredientService.getAllByName(page, elements, name));
    }

    @GetMapping("/id/{idIngredient}")
    public ResponseEntity<IngredientDTO> getById(@PathVariable int idIngredient) {
        return ResponseEntity.ok(this.ingredientService.getById(idIngredient));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<IngredientDTO> getByName(@PathVariable String name) {
        return ResponseEntity.ok(this.ingredientService.getByName(name));
    }

    @PostMapping
    public ResponseEntity<IngredientEntity> save(@RequestBody IngredientEntity newIngredient) {
        return ResponseEntity.ok(this.ingredientService.save(newIngredient));
    }

    @PutMapping
    public ResponseEntity<IngredientEntity> update(@RequestBody IngredientEntity newIngredient) {
        return ResponseEntity.ok(this.ingredientService.save(newIngredient));
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<IngredientEntity> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(this.ingredientService.delete(id));
    }

}
