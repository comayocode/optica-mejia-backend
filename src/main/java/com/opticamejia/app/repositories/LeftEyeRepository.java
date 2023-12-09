package com.opticamejia.app.repositories;

import com.opticamejia.app.models.LeftEyeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeftEyeRepository extends CrudRepository<LeftEyeModel, Integer> {
}
