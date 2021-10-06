package com.tidii.optimusapi.services;

import com.tidii.optimusapi.dto.DistrictDTO;
import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    // CRUD operations
    public District find(Long id) {
        Optional<District> obj = districtRepository.findById(id);
        return obj.orElse(null);
    }

    @Transactional
    public District insert(District obj) {
        obj.setId(null);
        obj = districtRepository.save(obj);
        return obj;
    }

    @Transactional
    public District update(District obj) {
        District newObj = find(obj.getId());
        updateData(newObj, obj);
        newObj = districtRepository.save(newObj);
        return newObj;
    }

    // Utils
    @Transactional
    public void addStreet(District district, Street street) {
        if (street.getIsLeaking()) {
            district.setIsLeaking(true);
            district.setInfo("Leak detected");
        }

        district.getStreets().add(street);
        districtRepository.save(district);
    }

    @Transactional
    public void setInfoAndLeaking(District district, Street street) {
        if (street.getIsLeaking()) {
            district.setIsLeaking(true);
            district.setInfo("Leak detected");
        }
        districtRepository.save(district);
    }

    public District fromDTO(DistrictDTO objDto) {
        return new District(objDto.getId(), objDto.getName(), objDto.getInfo(), objDto.getLeakingSituation());
    }

    public void updateData(District newObj, District obj) {
        newObj.setId(obj.getId());
        newObj.setName(obj.getName());
        newObj.setInfo(obj.getInfo());
        newObj.setIsLeaking(obj.getIsLeaking());
    }
}
