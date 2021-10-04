package com.tidii.optimusapi.services;

import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public Street find(Long id) {
        Optional<Street> obj = streetRepository.findById(id);
        return obj.orElse(null);
    }
}
