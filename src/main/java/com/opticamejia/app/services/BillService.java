package com.opticamejia.app.services;

import com.opticamejia.app.models.BillModel;
import com.opticamejia.app.models.PatientModel;
import com.opticamejia.app.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    public ArrayList<BillModel> getBills() {
        return (ArrayList<BillModel>) billRepository.findAll();
    }

    public BillModel saveBill(BillModel bill) {
        return billRepository.save(bill);
    }

    public Optional<BillModel> getById(Integer id) {
        return billRepository.findById(id);
    }

    public ArrayList<BillModel> getByCode(String code) {
        return billRepository.findByCode(code);
    }

    public boolean deleteBill(Integer id) {
        try {
            billRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
