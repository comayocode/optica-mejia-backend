package com.opticamejia.app.controllers;

import com.opticamejia.app.models.FormulaModel;
import com.opticamejia.app.models.LeftEyeModel;
import com.opticamejia.app.services.FormulaService;
import com.opticamejia.app.services.LeftEyeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ArrayList<LeftEyeModel> getLeftEye() {
        return leftEyeService.getLeftEye();
    }

    @PostMapping()
    public LeftEyeModel saveLeftEye(@RequestBody LeftEyeModel leftEye) {

        FormulaModel formula = formulaService.getById(12).get();
        leftEye.setFormula(formula);

        return  this.leftEyeService.saveLeftEye(leftEye);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")Integer id) {
        boolean ok = this.leftEyeService.deleteLeftEye(id);
        if(ok) {
            return "Parámetros del ojo izquierdo eliminados";
        } else {
            return "No se eliminaron los parámetros";
        }
    }

}
