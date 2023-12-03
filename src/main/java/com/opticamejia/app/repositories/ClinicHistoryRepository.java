package com.opticamejia.app.repositories;

import com.opticamejia.app.models.ClinicHistoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicHistoryRepository extends CrudRepository<ClinicHistoryModel, Integer> {

}
