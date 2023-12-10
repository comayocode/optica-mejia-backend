package com.opticamejia.app.services;

import com.opticamejia.app.models.ModuleModel;
import com.opticamejia.app.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    public ArrayList<ModuleModel> getModules() {
        return (ArrayList<ModuleModel>) moduleRepository.findAll();
    }

    public ModuleModel saveModule(ModuleModel module) {
        return moduleRepository.save(module);
    }

    public boolean deleteById(Integer id) {
        try {
            moduleRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
