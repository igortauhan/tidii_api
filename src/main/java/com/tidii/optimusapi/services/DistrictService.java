package com.tidii.optimusapi.services;

import com.tidii.optimusapi.dto.DistrictDTO;
import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.repositories.DistrictRepository;
import com.tidii.optimusapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    // CRUD operations
    @Transactional
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Transactional
    public District find(Long id) {
        Optional<District> obj = districtRepository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + District.class.getName())
        );
    }

    public District findDistrictByNameIgnoreCase(String name) {
        Optional<District> obj = districtRepository.findDistrictByNameIgnoreCase(name);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Object not found! Name: " +
                                name +
                                ", Type: " +
                                District.class.getName()
                )
        );
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
        newObj = newObj.setInfo(newObj);
        newObj = districtRepository.save(newObj);
        return newObj;
    }

    // Utils
    @Transactional
    public void addStreet(District district, Street street) {
        district.getStreets().add(street);
        changeInfoByLeaking(district);
        districtRepository.save(district);
    }

    public void changeInfoByLeaking(District district) {
        for (Street street : district.getStreets()) {
            if (street.getIsLeaking()) {
                district.setIsLeaking(true);
                district.setInfo("Vazamento detectado");
                return;
            }
        }

        district.setIsLeaking(false);
        district.setInfo("Atividade normal");
        district = update(district);
    }

    public District fromDTO(DistrictDTO objDto) {
        return new District(objDto.getId(), objDto.getName(), objDto.getLeakingSituation());
    }

    public void updateData(District newObj, District obj) {
        newObj.setId(obj.getId());
        if (obj.getName() != null) {
            newObj.setName(obj.getName());
        }
        newObj.setInfo(obj.getInfo());
        newObj.setIsLeaking(obj.getIsLeaking());
    }
}
