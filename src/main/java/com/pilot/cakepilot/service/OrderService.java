package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.OrderEntity;
import com.pilot.cakepilot.persistence.repository.OrderRepository;
import com.pilot.cakepilot.service.dtos.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAll() {
        List<OrderEntity> entities = this.orderRepository.findAll();
        return entities.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }
}
