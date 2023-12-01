// recibir petición web la cual proveerá los métodos para el CRUD

package com.opticamejia.app.controllers;

import com.opticamejia.app.models.PatientModel;
import com.opticamejia.app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController // indicar controlador rest
@RequestMapping("/patient") // ruta que activa los métodos de la clase
public class PatientController {

    @Autowired // instanciar automáticamente PatientService
    PatientService patientService;

    @GetMapping() // método para petición get
    public ArrayList<PatientModel> getPatients() {
        return patientService.getPatients(); // llamar método getPatients de PatientService
    }

    @PostMapping() // método para petición post
    public PatientModel savePatient(@RequestBody PatientModel patient) { // recibe como parámetro RequestBody, se puede enviar información dentro del cuerpo de la solicitud HTTP guardándolo en el usuario
        return this.patientService.savePatient(patient);// regresar el usuario actualizado con su id
    }

    // mostrar usuario por su id
    @GetMapping(path = "/{id}") // localhost:8080/patient/2
    public Optional<PatientModel> getById(@PathVariable("id") Integer id) {
        return this.patientService.getById(id); // llamar método de PatientService
    }

    // obtener paciente por su cc aplicando query param
    @GetMapping("/query") // nuevo servicio para buscar por cc, pasando los parámetros en la query: localhost:8080/patient/query?id_card=1234567
    public ArrayList<PatientModel> getByCc(@RequestParam("cc") Integer cc) {
        return this.patientService.getByCc(cc);
    }


    //
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean ok = this.patientService.deletePatient(id);
        if (ok) {
            return "Paciente" + id + "eliminado correctamente";
        } else {
            return "Paciente" + id + "no se eliminó";
        }
    }
}
