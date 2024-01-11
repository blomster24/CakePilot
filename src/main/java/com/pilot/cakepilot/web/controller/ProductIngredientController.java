package com.pilot.cakepilot.web.controller;

import com.pilot.cakepilot.service.ProductIngredientService;
import com.pilot.cakepilot.service.dtos.ProductIngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-ingredients")
public class ProductIngredientController {

    private final ProductIngredientService service;

    @Autowired
    public ProductIngredientController(ProductIngredientService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<ProductIngredientDTO>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }
}
