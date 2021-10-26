package com.tidii.optimusapi.controllers;

import com.tidii.optimusapi.dto.DistrictDTO;
import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<DistrictDTO>> findAll() {
        List<District> list = districtService.findAll();
        List<DistrictDTO> listDto = list.stream().map(obj -> new DistrictDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<District> find(@PathVariable Long id) {
        District obj = districtService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody DistrictDTO objDto) {
        District obj = districtService.fromDTO(objDto);
        obj = districtService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody DistrictDTO objDto) {
        District obj = districtService.fromDTO(objDto);
        obj.setId(id);
        obj = districtService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
