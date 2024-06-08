package org.krytev.bookstore.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_types")
public class DeliveryTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
