package com.tidii.optimusapi.services;

import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public District find (Long id) {
        Optional<District> obj = districtRepository.findById(id);
        return obj.orElse(null);
    }

}
