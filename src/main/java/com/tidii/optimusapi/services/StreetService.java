package com.tidii.optimusapi.services;

import com.tidii.optimusapi.dto.StreetDTO;
import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private DistrictService districtService;

    // CRUD operations
    public Street find(Long id) {
        Optional<Street> obj = streetRepository.findById(id);
        return obj.orElse(null);
    }

    @Transactional
    public Street insert(Street obj) {
        obj.setId(null);
        District district = districtService.find(obj.getDistrict().getId());
        districtService.addStreet(district, obj);
        obj = streetRepository.save(obj);
        return obj;
    }

    @Transactional
    public Street update(Street obj) {
        Street newObj = find(obj.getId());
        updateData(newObj, obj);

        District district = districtService.find(newObj.getDistrict().getId());
        districtService.setInfoAndLeaking(district, newObj);

        newObj = streetRepository.save(newObj);
        return newObj;
    }

    // Utils
    public void updateData(Street newObj, Street obj) {
        newObj.setId(obj.getId());
        newObj.setName(obj.getName());
        newObj.setInfo(obj.getInfo());
        newObj.setIsLeaking(obj.getIsLeaking());
    }

    public Street fromDto(StreetDTO objDto, District district) {
        return new Street(objDto.getId(), objDto.getName(), objDto.getInfo(), objDto.getLeakingSituation(), district);
    }

    public Street fromDto(StreetDTO objDto) {
        return new Street(objDto.getId(), objDto.getName(), objDto.getInfo(), objDto.getLeakingSituation());
    }

    @Transactional(readOnly = true)
    public District getDistrictById(Long id) {
        return districtService.find(id);
    }
}
