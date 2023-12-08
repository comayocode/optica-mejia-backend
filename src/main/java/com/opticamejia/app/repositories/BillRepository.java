package com.opticamejia.app.repositories;

import com.opticamejia.app.models.BillModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BillRepository extends CrudRepository<BillModel, Integer> {
    public abstract ArrayList<BillModel> findByCode(String bill_code);
}
