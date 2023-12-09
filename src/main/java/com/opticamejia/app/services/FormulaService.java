package com.opticamejia.app.services;

import com.opticamejia.app.models.ClinicHistoryModel;
import com.opticamejia.app.models.FormulaModel;
import com.opticamejia.app.repositories.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FormulaService {

    @Autowired
    FormulaRepository formulaRepository;

    @Autowired
    ClinicHistoryService clinicHistoryService;

    public ArrayList<FormulaModel> getFormulas() {
        return (ArrayList<FormulaModel>) formulaRepository.findAll();
    }

    public FormulaModel saveFormula(FormulaModel formula) {
        return  formulaRepository.save(formula);
    }

    public Optional<FormulaModel> getById(Integer id) {
        return formulaRepository.findById(id);
    }

    public boolean deleteFormula(Integer id) {
        try {
            formulaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
