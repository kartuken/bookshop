package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.CartEntity;
import org.krytev.bookstore.domain.PositionEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PositionRepository extends CrudRepository<PositionEntity, Long> {

    Optional<PositionEntity> findByBookAndUser(BookEntity book, UserEntity user);

    List<PositionEntity> findByUser(UserEntity user);

}
