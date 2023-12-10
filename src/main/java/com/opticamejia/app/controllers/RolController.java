package com.opticamejia.app.controllers;

import com.opticamejia.app.models.RolModel;
import com.opticamejia.app.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping()
    public ArrayList<RolModel> getRoles() {
        return rolService.getRoles();
    }

    @PostMapping()
    public RolModel saveRol(@RequestBody RolModel rol) {
        return this.rolService.saveRol(rol);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Integer id) {
        boolean ok = rolService.deleteRol(id);
        if (ok) {
            return "Rol eliminado correctamente";
        } else {
            return "Error al eliminar el rol";
        }
    }
}
