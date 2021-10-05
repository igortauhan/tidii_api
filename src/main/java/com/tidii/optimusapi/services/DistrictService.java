package com.tidii.optimusapi.services;

import com.tidii.optimusapi.dto.DistrictDTO;
import com.tidii.optimusapi.entities.District;
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

    // Utils
    @Transactional
    public District fromDTO(DistrictDTO objDto) {
        return new District(null, objDto.getName(), objDto.getInfo(), objDto.getLeakingSituation());
    }
}
