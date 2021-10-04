package com.tidii.optimusapi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_streets")
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String info;
    private Boolean situation;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    public Street () {

    }

    public Street(Long id, String name, String info, Boolean situation, District district) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.situation = situation;
        this.district = district;
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

    public Boolean getSituation() {
        return situation;
    }

    public void setSituation(Boolean situation) {
        this.situation = situation;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
