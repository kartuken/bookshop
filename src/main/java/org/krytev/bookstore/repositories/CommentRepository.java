package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}
