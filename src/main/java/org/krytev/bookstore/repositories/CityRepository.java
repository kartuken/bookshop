package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.CityEntity;
import org.krytev.bookstore.domain.FilialEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Long> {
    List<CityEntity> findAll();
}
