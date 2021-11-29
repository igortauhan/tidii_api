package com.tidii.optimusapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_districts")
public class District implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String info;
    private Boolean isLeaking;

    @JsonManagedReference
    @OneToMany(mappedBy = "district")
    private List<Street> streets = new ArrayList<>();

    public District() {

    }

    public District(Long id, Boolean isLeaking) {
        this.id = id;
        this.isLeaking = isLeaking;
    }

    public District(Long id, String name, Boolean isLeaking) {
        this.id = id;
        this.name = name;
        this.isLeaking = isLeaking;
    }

    public District(Long id, String name, String info, Boolean isLeaking) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.isLeaking = isLeaking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public District setInfo(District obj) {
        if (obj.getIsLeaking()) {
            obj.setInfo("Vazamento detectado");
            return obj;
        }

        obj.setInfo("Atividade normal");
        return obj;
    }

    public Boolean getIsLeaking() {
        return isLeaking;
    }

    public void setIsLeaking(Boolean isLeaking) {
        this.isLeaking = isLeaking;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

}
