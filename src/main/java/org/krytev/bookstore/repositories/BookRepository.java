package org.krytev.bookstore.repositories;

import jakarta.persistence.OrderBy;
import org.krytev.bookstore.domain.BookEntity;
import org.krytev.bookstore.domain.GenreEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    List<BookEntity> findAll();

    @Query(value = "select book from BookEntity book order by (select count(likes) from LikeEntity likes where likes.book = book) desc")
    List<BookEntity> findMostLiked(Pageable pageable);
//select book from BookEntity book left join book.likes likes group by book order by count(likes) desc
    @Query(value = "select book from BookEntity book order by book.creationTime desc")
    List<BookEntity> findNewBooks(Pageable pageable);

    @Query(value = "select book from BookEntity book where book.genre = :genre order by book.creationTime desc")
    List<BookEntity> findByGenre(@Param("genre") GenreEntity genre, Pageable pageable);
}
