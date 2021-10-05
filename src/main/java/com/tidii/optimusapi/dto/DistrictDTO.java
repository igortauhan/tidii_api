package com.tidii.optimusapi.dto;

import java.io.Serializable;

public class DistrictDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String info;
    private Boolean leakingSituation;

    public DistrictDTO() {

    }

    public DistrictDTO(Long id, String name, String info, Boolean leakingSituation) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.leakingSituation = leakingSituation;
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
}
