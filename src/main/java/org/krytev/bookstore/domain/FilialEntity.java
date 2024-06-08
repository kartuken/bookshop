package org.krytev.bookstore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "filials")
public class FilialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String time;

    @OneToMany
    private List <OrderEntity> orders;

}
