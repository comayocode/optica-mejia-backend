package com.opticamejia.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "formulas")
public class FormulasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private ClinicHistoryModel clinic_history; // se relaciona con @OneToOne(mappedBy = "clinic_history") de ClinicHistoryModel

    @OneToOne(mappedBy = "formula")
    private LeftEyeModel left_eye;


    @OneToOne(mappedBy = "formula") // debe ser igual que la variable "formula" de tipo FormulaModel en la clase RightEyeModel
    private RightEyeModel right_eye;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClinicHistoryModel getClinic_history() {
        return clinic_history;
    }

    public void setClinic_history(ClinicHistoryModel clinic_history) {
        this.clinic_history = clinic_history;
    }

    public LeftEyeModel getLeft_eye() {
        return left_eye;
    }

    public void setLeft_eye(LeftEyeModel left_eye) {
        this.left_eye = left_eye;
    }

    public RightEyeModel getRight_eye() {
        return right_eye;
    }

    public void setRight_eye(RightEyeModel right_eye) {
        this.right_eye = right_eye;
    }


}
