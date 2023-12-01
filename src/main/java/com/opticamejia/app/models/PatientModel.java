package com.opticamejia.app.models;

import jakarta.persistence.*;

@Entity // indicar que es un modelo real
@Table(name = "patients") // crear tabla "patients"
public class PatientModel {

    @Id // marcar como id en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generar id automático e incrementable
    @Column(unique = true, nullable = false) // debe ser único y no puede ser nulo
    private int id;
    private int cc;
    private String name;
    private int age;
    private String address;
    private String personal_cellphone;
    private String family_cellphone;
    private String occupation;
    private String eps;
    private String pathologies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonal_cellphone() {
        return personal_cellphone;
    }

    public void setPersonal_cellphone(String personal_cellphone) {
        this.personal_cellphone = personal_cellphone;
    }

    public String getFamily_cellphone() {
        return family_cellphone;
    }

    public void setFamily_cellphone(String family_cellphone) {
        this.family_cellphone = family_cellphone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getPathologies() {
        return pathologies;
    }

    public void setPathologies(String pathologies) {
        this.pathologies = pathologies;
    }
}
