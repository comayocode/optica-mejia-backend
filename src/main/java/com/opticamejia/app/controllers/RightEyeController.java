package com.opticamejia.app.controllers;

import com.opticamejia.app.models.FormulaModel;
import com.opticamejia.app.models.RightEyeModel;
import com.opticamejia.app.services.FormulaService;
import com.opticamejia.app.services.RightEyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/right-eye")
public class RightEyeController {

    @Autowired
    RightEyeService rightEyeService;

    @Autowired
    FormulaService formulaService;

    @GetMapping()
    public ArrayList<RightEyeModel> getRightEye() {
        return rightEyeService.getRightEye();
    }

    @PostMapping()
    public RightEyeModel saveRightEye(@RequestBody RightEyeModel rightEye) {
        FormulaModel formula = formulaService.getById(12).get();
        rightEye.setFormula(formula);

        return this.rightEyeService.saveRightEye(rightEye);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")Integer id) {
        boolean ok = this.rightEyeService.deleteRightEye(id);
        if(ok) {
            return "Parámetros del ojo derecho eliminados";
        } else {
            return "No se eliminaron los parámetros";
        }
    }

}
