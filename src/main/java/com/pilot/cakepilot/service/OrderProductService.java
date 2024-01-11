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

@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    @Autowired
    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public List<OrderProductDTO> getAll() {
        List<OrderProductEntity> orderProductEntityList = this.orderProductRepository.findAll();
        List<OrderProductDTO> orderProductDTOS = new ArrayList<>();

        orderProductEntityList.forEach(orderProduct -> {
            OrderProductDTO orderProductDTO = new OrderProductDTO();
            orderProductDTO.setId(orderProduct.getId());
            orderProductDTO.setIdProduct(orderProduct.getIdProduct());
            orderProductDTO.setIdOrder(orderProduct.getIdOrder());
            orderProductDTO.setQuantity(orderProduct.getQuantity());

            orderProductDTOS.add(orderProductDTO);
        });
        return orderProductDTOS;
    }

}
