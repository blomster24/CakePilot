package com.pilot.cakepilot.service.dtos;

import com.pilot.cakepilot.persistence.entity.CustomerEntity;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CustomerDTO {

    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    public CustomerDTO(CustomerEntity customer) {
        this.name = customer.getName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
    }
}
