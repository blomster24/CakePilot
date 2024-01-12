package com.pilot.cakepilot.service;

import com.pilot.cakepilot.persistence.entity.CustomerEntity;
import com.pilot.cakepilot.persistence.repository.CustomerRepository;
import com.pilot.cakepilot.service.dtos.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerDTO> getAll() {
        List<CustomerEntity> entities = this.repository.findAll();
        return entities.stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }
}
