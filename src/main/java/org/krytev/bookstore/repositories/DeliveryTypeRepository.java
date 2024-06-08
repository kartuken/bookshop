package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.DeliveryTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryTypeRepository extends CrudRepository<DeliveryTypeEntity, Long> {
}
