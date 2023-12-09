package com.opticamejia.app.services;

import com.opticamejia.app.models.LeftEyeModel;
import com.opticamejia.app.models.RightEyeModel;
import com.opticamejia.app.repositories.RightEyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RightEyeService {

    @Autowired
    RightEyeRepository rightEyeRepository;

    public ArrayList<RightEyeModel> getRightEye() {
        return (ArrayList<RightEyeModel>) rightEyeRepository.findAll();
    }

    public RightEyeModel saveRightEye(RightEyeModel rightEye) {
        return rightEyeRepository.save(rightEye);
    }

    public boolean deleteRightEye(Integer id) {
        try {
            rightEyeRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
