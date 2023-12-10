package com.opticamejia.app.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "role_modules")
public class RoleModuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @ManyToOne
    private RolModel role;

    @ManyToOne
    private ModuleModel module;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolModel getRole() {
        return role;
    }

    public void setRole(RolModel role) {
        this.role = role;
    }

    public ModuleModel getModule() {
        return module;
    }

    public void setModule(ModuleModel module) {
        this.module = module;
    }
}
