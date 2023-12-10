package com.opticamejia.app.repositories;

import com.opticamejia.app.models.ModuleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<ModuleModel, Integer> {
}
