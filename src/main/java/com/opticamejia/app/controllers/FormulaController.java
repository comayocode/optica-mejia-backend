package com.opticamejia.app.controllers;

import com.opticamejia.app.models.ClinicHistoryModel;
import com.opticamejia.app.models.FormulaModel;
import com.opticamejia.app.services.ClinicHistoryService;
import com.opticamejia.app.services.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.ArrayList;

@RestController
@RequestMapping("/formula")
public class FormulaController {

    @Autowired
    FormulaService formulaService;

    @Autowired
    ClinicHistoryService clinicHistoryService;

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public ArrayList<FormulaModel> getFormulas() {
         return formulaService.getFormulas();
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public FormulaModel saveFormula(@PathVariable("id") Integer id, @RequestBody FormulaModel formula) {

        ClinicHistoryModel clinicHistory = clinicHistoryService.getById(id).get();
        formula.setClinic_history(clinicHistory);

        return this.formulaService.saveFormula(formula);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public String deleteById(@PathVariable("id")Integer id) {
        boolean ok = this.formulaService.deleteFormula(id);
        if(ok) {
            return "Formula eliminada";
        } else {
            return "Error al eliminar la fórmula";
        }

    }
}
