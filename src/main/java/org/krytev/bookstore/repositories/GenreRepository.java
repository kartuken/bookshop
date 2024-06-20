package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.GenreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<GenreEntity, Long> {
    List<GenreEntity> findAll();
    Optional<GenreEntity> findByName(String name);
}
