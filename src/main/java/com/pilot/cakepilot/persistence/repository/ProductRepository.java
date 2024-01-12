package com.pilot.cakepilot.persistence.repository;

import com.pilot.cakepilot.persistence.entity.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<ProductEntity,Integer> {
}
