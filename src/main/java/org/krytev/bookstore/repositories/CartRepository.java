package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.CartEntity;
import org.krytev.bookstore.domain.FilialEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<CartEntity, Long> {
    List<CartEntity> findAll();
}
