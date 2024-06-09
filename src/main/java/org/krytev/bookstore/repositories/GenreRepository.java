package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.GenreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<GenreEntity, Long> {
    List<GenreEntity> findAll();
}
