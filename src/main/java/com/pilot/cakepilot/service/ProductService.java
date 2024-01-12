package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.ProductEntity;
import com.pilot.cakepilot.persistence.repository.ProductRepository;
import com.pilot.cakepilot.service.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDTO> getAll() {
        List<ProductEntity> entities = this.repository.findAll();
        return entities.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}
