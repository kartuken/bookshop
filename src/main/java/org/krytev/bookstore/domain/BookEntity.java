package org.krytev.bookstore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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

    private LocalDateTime creationTime;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private GenreEntity genre;

    @OneToMany
    private List <CommentEntity> comments;

    @OneToMany(fetch = FetchType.EAGER)
    private List <LikeEntity> likes;

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", creationTime=" + creationTime +
                ", description='" + description + '\'' +
                ", likes=" + getLikes() +
                '}';
    }
}
