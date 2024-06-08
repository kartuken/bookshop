package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.LikeEntity;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<LikeEntity, Long> {
}
