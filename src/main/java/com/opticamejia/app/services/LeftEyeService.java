package com.opticamejia.app.services;

import com.opticamejia.app.models.LeftEyeModel;
import com.opticamejia.app.repositories.LeftEyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LeftEyeService {

    @Autowired
    LeftEyeRepository leftEyeRepository;

    public ArrayList<LeftEyeModel> getLeftEye() {
        return (ArrayList<LeftEyeModel>) leftEyeRepository.findAll();
    }

    public LeftEyeModel saveLeftEye(LeftEyeModel leftEye) {
        return leftEyeRepository.save(leftEye);
    }

    public boolean deleteLeftEye(Integer id) {
        try {
            leftEyeRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
