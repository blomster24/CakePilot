package com.pilot.cakepilot.service.dtos;

import com.pilot.cakepilot.persistence.entity.OrderEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderDTO {

    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private String status;
    private Double totalAmount;
    private String payMethod;

    public OrderDTO(OrderEntity order) {
        this.orderDate = order.getOrderDate();
        this.deliveryDate = order.getDeliveryDate();
        this.status = order.getStatus();
        this.totalAmount = order.getTotalAmount();
        this.payMethod = order.getPayMethod();
    }
}
