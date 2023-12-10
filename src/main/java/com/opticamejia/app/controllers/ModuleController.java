package com.opticamejia.app.controllers;

import com.opticamejia.app.models.ModuleModel;
import com.opticamejia.app.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @GetMapping()
    public ArrayList<ModuleModel> getModules() {
        return moduleService.getModules();
    }

    @PostMapping()
    public ModuleModel saveModule(@RequestBody ModuleModel module) {
        return this.moduleService.saveModule(module);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean ok = this.moduleService.deleteById(id);
        if (ok) {
            return "Módulo eliminado correctamente";
        } else {
            return "Error al eliminar el módulo";
        }
    }
}
