package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
