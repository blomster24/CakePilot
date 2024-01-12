package com.pilot.cakepilot.persistence.repository;

import com.pilot.cakepilot.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
}
