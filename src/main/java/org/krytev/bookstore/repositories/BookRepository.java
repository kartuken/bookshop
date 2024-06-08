package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
