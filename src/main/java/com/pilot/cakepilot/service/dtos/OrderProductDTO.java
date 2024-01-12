package com.pilot.cakepilot.service.dtos;

import com.pilot.cakepilot.persistence.entity.OrderProductEntity;
import lombok.Getter;

@Getter
public class OrderProductDTO {

    private Integer idOrder;
    private Integer idProduct;
    private Integer quantity;

    public OrderProductDTO(OrderProductEntity orderProduct) {
        this.idOrder = orderProduct.getIdOrder();
        this.idProduct = orderProduct.getIdProduct();
        this.quantity = orderProduct.getQuantity();
    }
}
