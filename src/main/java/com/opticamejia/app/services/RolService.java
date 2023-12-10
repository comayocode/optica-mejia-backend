package com.opticamejia.app.services;

import com.opticamejia.app.models.RolModel;
import com.opticamejia.app.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public ArrayList<RolModel> getRoles() {
        return (ArrayList<RolModel>) rolRepository.findAll();
    }

    public RolModel saveRol(RolModel rol) {
        return  rolRepository.save(rol);
    }

    public boolean deleteRol(Integer id) {
        try {
            rolRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
