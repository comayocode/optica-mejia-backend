package com.opticamejia.app.repositories;

import com.opticamejia.app.models.RightEyeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RightEyeRepository extends CrudRepository<RightEyeModel, Integer> {
}
