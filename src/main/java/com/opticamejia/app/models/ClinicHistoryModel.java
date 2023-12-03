package com.opticamejia.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="clinic_history")
public class ClinicHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private int code;
    private Date date;
    private String observations;
    private String prescription;

    @ManyToOne // muchas historia clínicas pertenecen a un paciente
    @JsonIgnore // ignorar el paciente en el JSON
    private PatientModel patient;

    @OneToOne(mappedBy = "clinic_history")
    @JsonIgnore // ignorar la formula en el JSON
    private FormulasModel formula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public FormulasModel getFormula() {
        return formula;
    }

    public void setFormula(FormulasModel formula) {
        this.formula = formula;
    }
}
