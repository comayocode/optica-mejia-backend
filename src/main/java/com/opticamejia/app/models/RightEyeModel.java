package com.opticamejia.app.models;

import jakarta.persistence.*;

@Entity
@Table(name="right_eye")
public class RightEyeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sphere;
    private String cylinder;
    private String axis;
    private String addition;
    private String pupilarydistance;

    @OneToOne
    private FormulaModel formula; // esta varibale de tipo FormulasModel debe coincidir con el mappedBy de la clase ClinicHistoryModel

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSphere() {
        return sphere;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getPupilarydistance() {
        return pupilarydistance;
    }

    public void setPupilarydistance(String pupilarydistance) {
        this.pupilarydistance = pupilarydistance;
    }

    public FormulaModel getFormula() {
        return formula;
    }

    public void setFormula(FormulaModel formula) {
        this.formula = formula;
    }
}
