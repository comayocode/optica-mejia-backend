package com.opticamejia.app.controllers;

import com.opticamejia.app.models.ClinicHistoryModel;
import com.opticamejia.app.models.PatientModel;
import com.opticamejia.app.services.ClinicHistoryService;
import com.opticamejia.app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public ArrayList<ClinicHistoryModel> getClinicHistories() {
        return clinicHistoryService.getClinicHistories();
    }

    // obtener historia clínica única por el id = localhost:8080/clinic-history/{id}
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public Optional<ClinicHistoryModel> getById(@PathVariable("id") Integer id) {
        return this.clinicHistoryService.getById(id);
    }

    // guardar historia clínica
    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public ClinicHistoryModel saveClinicHistory(@PathVariable("id") Integer id, @RequestBody ClinicHistoryModel clinicHistory) {

        Date date = new Date();
        clinicHistory.setDate(date); // guardar la fecha actual automáticamente

        PatientModel patient = patientService.getById(id).get(); // obtener el paciente con X id
        clinicHistory.setPatient(patient); // enviar el paciente con id X manuelmente (más adelante se enviará dinámicamente)

        return this.clinicHistoryService.saveClinicHistory(clinicHistory);
    }

    // eliminar historia clínica por su id
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'OPTOMETRA')")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean ok = this.clinicHistoryService.deleteClinicHistory(id);
        if (ok) {
            return "Historia clínica eliminada";
        } else {
            return "Error al eliminar";
        }
    }

}
