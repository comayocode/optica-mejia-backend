package com.opticamejia.app.services;

import com.opticamejia.app.models.ClinicHistoryModel;
import com.opticamejia.app.repositories.ClinicHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClinicHistoryService {

    @Autowired
    ClinicHistoryRepository clinicHistoryRepository;

    // obtener todas las historias
    public ArrayList<ClinicHistoryModel> getClinicHistories() {
        return (ArrayList<ClinicHistoryModel>) clinicHistoryRepository.findAll();
    }

    // obtener una única historia por su id
    public Optional<ClinicHistoryModel> getById(Integer id) {
        return clinicHistoryRepository.findById(id);
    }

    // guardar una historia
    public ClinicHistoryModel saveClinicHistory(ClinicHistoryModel clinicHistory) {
        return  clinicHistoryRepository.save(clinicHistory);
    }

    // eliminar una historia
    public boolean deleteClinicHistory(Integer id) {
        try {
            clinicHistoryRepository.deleteById(id);
            return true;
        }catch (Exception err) {
            return false;
        }
    }

}
