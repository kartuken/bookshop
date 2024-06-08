package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.GenreEntity;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<GenreEntity, Long> {
}
