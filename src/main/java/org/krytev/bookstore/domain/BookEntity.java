package org.krytev.bookstore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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

    private LocalDate creationTime;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private GenreEntity genre;

    @OneToMany
    private List <CommentEntity> comments;

    @OneToMany(fetch = FetchType.EAGER)
    private List <LikeEntity> likes;

}
