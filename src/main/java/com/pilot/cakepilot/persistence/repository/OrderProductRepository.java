package com.pilot.cakepilot.persistence.repository;

import com.pilot.cakepilot.persistence.entity.OrderProductEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderProductRepository extends ListCrudRepository<OrderProductEntity, Integer> {
}
