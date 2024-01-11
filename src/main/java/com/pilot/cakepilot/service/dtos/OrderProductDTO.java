package com.pilot.cakepilot.service.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderProductDTO {

    private Integer id;

    private Integer idOrder;

    private Integer idProduct;

    private Integer quantity;


}
