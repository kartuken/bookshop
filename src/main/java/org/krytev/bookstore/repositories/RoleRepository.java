package org.krytev.bookstore.repositories;

import org.krytev.bookstore.domain.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
