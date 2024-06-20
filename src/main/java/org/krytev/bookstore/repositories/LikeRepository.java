package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.LikeEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<LikeEntity, Long> {

    Optional<LikeEntity> findByUserAndBook(UserEntity user, BookEntity book);

    Integer countByBook(BookEntity book);

    @Query(value = "select like.book from LikeEntity like where like.user = :user")
    List<BookEntity> findLikedBooks(@Param("user") UserEntity user);
}
