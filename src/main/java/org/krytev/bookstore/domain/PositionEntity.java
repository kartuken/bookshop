package org.krytev.bookstore.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "positions")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookEntity book;

    private Integer amount;

    @ManyToOne
    private OrderEntity order;

    @ManyToOne
    private UserEntity user;

}
