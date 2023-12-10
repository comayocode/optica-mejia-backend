package com.opticamejia.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modules")
public class ModuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String name;

    @OneToMany(mappedBy = "module")
    @JsonIgnore
    private List<RoleModuleModel> roleModule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleModuleModel> getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(List<RoleModuleModel> roleModule) {
        this.roleModule = roleModule;
    }
}
