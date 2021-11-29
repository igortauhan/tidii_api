package com.tidii.optimusapi.services;

import com.tidii.optimusapi.dto.StreetDTO;
import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.repositories.StreetRepository;
import com.tidii.optimusapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private DistrictService districtService;

    // CRUD operations
    @Transactional
    public List<Street> findAll() {
        return streetRepository.findAll();
    }

    @Transactional
    public List<Street> findAllStreetsByDistrict(Long districtId) {
        District district = districtService.find(districtId);
        return district.getStreets();
    }

    @Transactional
    public Street find(Long id) {
        Optional<Street> obj = streetRepository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Street.class.getName())
        );
    }

    @Transactional
    public Street findStreetByNameIgnoreCase(String name) {
        Optional<Street> obj = streetRepository.findStreetByNameIgnoreCase(name);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Object not found! Name: " +
                                name +
                                ", Type: " +
                                Street.class.getName()
                )
        );
    }

    @Transactional
    public Street insert(Street obj) {
        obj.setId(null);

        // Set date to 1/1/1970 00:00 for not return null
        obj.setLeakingDate(new Date(0));

        District district = districtService.find(obj.getDistrict().getId());
        districtService.addStreet(district, obj);
        obj = streetRepository.save(obj);
        return obj;
    }

    @Transactional
    public Street update(Street obj) {
        Street newObj = find(obj.getId());
        updateData(newObj, obj);

        if (newObj.getIsLeaking()) {
            newObj.setLeakingDate(new Date());
        } else {
            // Set date to 1/1/1970 00:00 for not return null
            newObj.setLeakingDate(new Date(0));
        }

        newObj = newObj.setInfo(newObj);
        newObj = streetRepository.save(newObj);

        District district = districtService.find(newObj.getDistrict().getId());
        districtService.changeInfoByLeaking(district);
        return newObj;
    }

    // Utils
    public void updateData(Street newObj, Street obj) {
        newObj.setId(obj.getId());
        if (obj.getName() != null) {
            newObj.setName(obj.getName());
        }
        newObj.setInfo(obj.getInfo());
        newObj.setIsLeaking(obj.getIsLeaking());
    }

    public Street fromDto(StreetDTO objDto, District district) {
        return new Street(objDto.getId(), objDto.getName(), objDto.getLeakingSituation(), objDto.getLeakingDate(), district);
    }

    public Street fromDto(StreetDTO objDto) {
        return new Street(objDto.getId(), objDto.getName(), objDto.getLeakingSituation());
    }

    @Transactional(readOnly = true)
    public District getDistrictById(Long id) {
        return districtService.find(id);
    }
}
