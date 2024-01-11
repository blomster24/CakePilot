package com.pilot.cakepilot.web.controller;

import com.pilot.cakepilot.persistence.entity.OrderProductEntity;
import com.pilot.cakepilot.service.OrderProductService;
import com.pilot.cakepilot.service.dtos.OrderProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    private final OrderProductService orderProductService;

    @Autowired
    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public ResponseEntity<List<OrderProductDTO>> getAll() {
        return ResponseEntity.ok(this.orderProductService.getAll());
    }

}
