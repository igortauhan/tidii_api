package com.tidii.optimusapi.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class StreetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Required field")
    @Length(max = 100, message = "Max 100 characters")
    private String name;

    @NotEmpty(message = "Required field!")
    private String info;

    @NotNull(message = "Required field!")
    private Boolean leakingSituation;

    @NotNull(message = "Required field")
    private Long districtId;

    private Date leakingDate;

    public StreetDTO() {

    }

    public StreetDTO(Long id, String name, String info, Boolean leakingSituation, Long districtId) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.leakingSituation = leakingSituation;
        this.districtId = districtId;
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

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Date getLeakingDate() {
        return leakingDate;
    }

    public void setLeakingDate(Date leakingDate) {
        this.leakingDate = leakingDate;
    }
}
