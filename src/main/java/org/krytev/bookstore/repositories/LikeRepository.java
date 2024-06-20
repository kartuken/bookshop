package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.LikeEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LikeRepository extends CrudRepository<LikeEntity, Long> {

    Optional<LikeEntity> findByUserAndBook(UserEntity user, BookEntity book);

    Integer countByBook(BookEntity book);
}
