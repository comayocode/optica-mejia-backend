// la petición recibida por el contralor llama a un servicio

package com.opticamejia.app.services;

import com.opticamejia.app.models.PatientModel;
import com.opticamejia.app.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service // convertir la clase a un servicio
public class PatientService {

    @Autowired // "instanciar"
    PatientRepository patientRepository; // declarar repositorio como variable

    // método que obtiene todos los usuarios, regresando objetos de tipo PatientModel
    public ArrayList<PatientModel> getPatients() {
        return (ArrayList<PatientModel>) patientRepository.findAll(); // obtener todos los registros casteando los datos a un array de tipo PatientModel para regresar un JSON
    }

    // registrar un paciente a la DB, si no se le pasa un id se registra uno nuevo, si se le pasa un id se modifican los valores
    public PatientModel savePatient(PatientModel patient) {
        return patientRepository.save(patient);
    }

    // obtener por id, si existe un registro que coincida se retorna, de lo contrario no da error (por ello el Optional)
    public Optional<PatientModel> getById(Integer id) {
        return patientRepository.findById(id);
    }

    // obtener por cédula
    public ArrayList<PatientModel> getByCc(Integer cc) {
        return patientRepository.findByCc(cc);
    }

    // eliminar el usuario pasándo el ID
    public boolean deletePatient(Integer id) {
        try {
            patientRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
