package com.tidii.optimusapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tidii.optimusapi.entities.Street;

import java.io.Serializable;
import java.util.Date;

public class StreetNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String info;
    private Boolean leakingSituation;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date leakingDate;

    public StreetNewDTO() {

    }

    public StreetNewDTO(Street obj) {
        id = obj.getId();
        name = obj.getName();
        info = obj.getInfo();
        leakingSituation = obj.getIsLeaking();
        leakingDate = obj.getLeakingDate();
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

    public Boolean getLeakingSituation() {
        return leakingSituation;
    }

    public void setLeakingSituation(Boolean leakingSituation) {
        this.leakingSituation = leakingSituation;
    }

    public Date getLeakingDate() {
        return leakingDate;
    }

    public void setLeakingDate(Date leakingDate) {
        this.leakingDate = leakingDate;
    }
}
