package com.tidii.optimusapi.dto;

import com.tidii.optimusapi.entities.District;

public class DistrictNewDTO {

    private Long id;
    private String name;
    private String info;
    private Boolean leakingSituation;

    public DistrictNewDTO() {

    }

    public DistrictNewDTO(District obj) {
        id = obj.getId();
        name = obj.getName();
        info = obj.getInfo();
        leakingSituation = obj.getIsLeaking();
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
