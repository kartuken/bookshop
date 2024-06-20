package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.CityEntity;
import org.krytev.bookstore.domain.FilialEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilialRepository extends CrudRepository<FilialEntity, Long> {
    List<FilialEntity> findByCity(CityEntity cityEntity);

    List<FilialEntity> findAll();
}
