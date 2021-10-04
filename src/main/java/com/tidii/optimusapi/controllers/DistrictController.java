package com.tidii.optimusapi.controllers;

import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<District> find(@PathVariable Long id) {
        District obj = districtService.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
