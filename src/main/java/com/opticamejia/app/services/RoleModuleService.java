package com.opticamejia.app.services;

import com.opticamejia.app.models.RoleModuleModel;
import com.opticamejia.app.repositories.RoleModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleModuleService {

    @Autowired
    RoleModuleRepository roleModuleRepository;

    public ArrayList<RoleModuleModel> getRoleModules() {
        return (ArrayList<RoleModuleModel>) roleModuleRepository.findAll();
    }

    public RoleModuleModel saveRoleModule(RoleModuleModel roleModule) {
        return roleModuleRepository.save(roleModule);
    }

    public boolean deleteRoleModule(Integer id) {
        try {
            roleModuleRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
