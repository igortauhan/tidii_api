package com.tidii.optimusapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_streets")
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String info;
    private Boolean isLeaking;
    private Date leakingDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    public Street () {

    }

    public Street(Long id, String name, String info, Boolean isLeaking) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.isLeaking = isLeaking;
    }

    public Street(Long id, String name, String info, Boolean isLeaking,  Date leakingDate, District district) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.isLeaking = isLeaking;
        this.leakingDate = leakingDate;
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

    public Boolean getIsLeaking() {
        return isLeaking;
    }

    public void setIsLeaking(Boolean isLeaking) {
        this.isLeaking = isLeaking;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Date getLeakingDate() {
        return leakingDate;
    }

    public void setLeakingDate(Date leakingDate) {
        this.leakingDate = leakingDate;
    }
}
