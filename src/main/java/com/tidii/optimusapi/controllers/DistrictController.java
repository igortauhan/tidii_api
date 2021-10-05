package com.tidii.optimusapi.controllers;

import com.tidii.optimusapi.dto.DistrictDTO;
import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody DistrictDTO objDto) {
        District obj = districtService.fromDTO(objDto);
        obj = districtService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
