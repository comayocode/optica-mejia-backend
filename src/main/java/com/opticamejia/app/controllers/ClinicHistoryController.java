package com.opticamejia.app.controllers;

import com.opticamejia.app.models.ClinicHistoryModel;
import com.opticamejia.app.models.PatientModel;
import com.opticamejia.app.services.ClinicHistoryService;
import com.opticamejia.app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/clinic-history")
public class ClinicHistoryController {

    @Autowired
    ClinicHistoryService clinicHistoryService;

    @Autowired
    PatientService patientService;

    // mostrar todas las historias clínicas
    @GetMapping()
    public ArrayList<ClinicHistoryModel> getClinicHistories() {
        return clinicHistoryService.getClinicHistories();
    }

    // obtener historia clínica única por el id = localhost:8080/clinic-history/{id}
    @GetMapping(path = "/{id}")
    public Optional<ClinicHistoryModel> getById(@PathVariable("id") Integer id) {
        return this.clinicHistoryService.getById(id);
    }

    // guardar historia clínica
    @PostMapping
    public ClinicHistoryModel saveClinicHistory(@RequestBody ClinicHistoryModel clinicHistory) {

        Date date = new Date();
        clinicHistory.setDate(date); // guardar la fecha actual automáticamente

        PatientModel patient = patientService.getById(5).get(); // obtener el paciente con X id
        clinicHistory.setPatient(patient); // enviar el paciente con id X manuelmente (más adelante se enviará dinámicamente)

        return this.clinicHistoryService.saveClinicHistory(clinicHistory);
    }

    // eliminar historia clínica por su id
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean ok = this.clinicHistoryService.deleteClinicHistory(id);
        if (ok) {
            return "Historia clínica eliminada";
        } else {
            return "Error al eliminar";
        }
    }

}
