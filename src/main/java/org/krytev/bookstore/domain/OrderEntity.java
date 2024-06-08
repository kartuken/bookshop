package org.krytev.bookstore.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private DeliveryTypeEntity deliveryType;

    @ManyToOne
    private FilialEntity filial;

    @OneToMany
    private List <PositionEntity> positions;

}
