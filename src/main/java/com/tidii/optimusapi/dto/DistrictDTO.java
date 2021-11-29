package com.tidii.optimusapi.dto;

import com.tidii.optimusapi.entities.District;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DistrictDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Length(max = 100, message = "Max 100 characters")
    private String name;

    @NotNull(message = "Required field")
    private Boolean leakingSituation;

    public DistrictDTO() {

    }

    public DistrictDTO(District obj) {
        id = obj.getId();
        name = obj.getName();
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

    public Boolean getLeakingSituation() {
        return leakingSituation;
    }

    public void setLeakingSituation(Boolean leakingSituation) {
        this.leakingSituation = leakingSituation;
    }
}
