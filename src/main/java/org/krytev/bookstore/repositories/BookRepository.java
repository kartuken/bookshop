package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    List<BookEntity> findAll();
}
