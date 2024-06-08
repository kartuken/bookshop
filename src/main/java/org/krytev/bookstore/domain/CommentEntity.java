package org.krytev.bookstore.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private BookEntity book;

    private String text;

    private Integer rate;

}
