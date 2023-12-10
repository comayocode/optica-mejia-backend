package com.opticamejia.app.repositories;

import com.opticamejia.app.models.RoleModuleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleModuleRepository extends CrudRepository<RoleModuleModel, Integer> {
}
