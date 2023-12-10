package com.opticamejia.app.repositories;

import com.opticamejia.app.models.RolModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<RolModel, Integer> {
}
