package com.pilot.cakepilot.persistence.repository;

import com.pilot.cakepilot.persistence.entity.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity,Integer> {
}
