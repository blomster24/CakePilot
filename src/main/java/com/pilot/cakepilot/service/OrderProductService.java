package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.IngredientEntity;
import com.pilot.cakepilot.persistence.entity.OrderProductEntity;
import com.pilot.cakepilot.persistence.repository.OrderProductRepository;
import com.pilot.cakepilot.service.dtos.IngredientDTO;
import com.pilot.cakepilot.service.dtos.OrderProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    @Autowired
    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public List<OrderProductDTO> getAll() {
        List<OrderProductEntity> entities = this.orderProductRepository.findAll();
        return entities.stream()
                .map(OrderProductDTO::new)
                .collect(Collectors.toList());
    }
}
