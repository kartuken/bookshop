package org.krytev.bookstore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Integer year;

    private Double price;

    private String image;
    @ManyToOne
    private GenreEntity genre;

    @OneToMany
    private List <CommentEntity> comments;

    @OneToMany
    private List <LikeEntity> likes;

}
