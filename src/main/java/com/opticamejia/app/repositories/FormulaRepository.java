package com.opticamejia.app.repositories;

import com.opticamejia.app.models.FormulaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends CrudRepository<FormulaModel, Integer> {
}
