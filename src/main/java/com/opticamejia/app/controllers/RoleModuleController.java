package com.opticamejia.app.controllers;

import com.opticamejia.app.models.RoleModuleModel;
import com.opticamejia.app.services.RoleModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/role-module")
public class RoleModuleController {

    @Autowired
    RoleModuleService roleModuleService;

    @GetMapping()
    public ArrayList<RoleModuleModel> getRoleModules() {
        return roleModuleService.getRoleModules();
    }

    @PostMapping()
    public RoleModuleModel saveRoleModule(@RequestBody RoleModuleModel roleModule) {
        return this.roleModuleService.saveRoleModule(roleModule);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Integer id) {
        boolean ok = this.roleModuleService.deleteRoleModule(id);
        if (ok) {
            return "Conexion entre rol y módulo eliminado correctamente";
        } else {
            return "Error al eliminar la conexión entre rol y módulo";
        }
    }
}
