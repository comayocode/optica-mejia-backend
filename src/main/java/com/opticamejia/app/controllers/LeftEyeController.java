package com.opticamejia.app.controllers;

import com.opticamejia.app.models.FormulaModel;
import com.opticamejia.app.models.LeftEyeModel;
import com.opticamejia.app.services.FormulaService;
import com.opticamejia.app.services.LeftEyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/left-eye")
public class LeftEyeController {

    @Autowired
    LeftEyeService leftEyeService;

    @Autowired
    FormulaService formulaService;

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public ArrayList<LeftEyeModel> getLeftEye() {
        return leftEyeService.getLeftEye();
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public LeftEyeModel saveLeftEye(@PathVariable("id") Integer id, @RequestBody LeftEyeModel leftEye) {

        FormulaModel formula = formulaService.getById(id).get();
        leftEye.setFormula(formula);

        return  this.leftEyeService.saveLeftEye(leftEye);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public String deleteById(@PathVariable("id")Integer id) {
        boolean ok = this.leftEyeService.deleteLeftEye(id);
        if(ok) {
            return "Parámetros del ojo izquierdo eliminados";
        } else {
            return "No se eliminaron los parámetros";
        }
    }

}
