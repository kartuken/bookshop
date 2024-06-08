package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.PositionEntity;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<PositionEntity, Long> {
}
