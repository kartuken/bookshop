package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Long> {
}
