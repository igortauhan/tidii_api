package com.tidii.optimusapi.controllers;

import com.tidii.optimusapi.dto.StreetDTO;
import com.tidii.optimusapi.dto.StreetNewDTO;
import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/streets")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @GetMapping
    public ResponseEntity<List<StreetNewDTO>> findAll() {
        List<Street> list = streetService.findAll();
        List<StreetNewDTO> listDto = list.stream().map(obj -> new StreetNewDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Street> find(@PathVariable Long id) {
        Street obj = streetService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody StreetDTO objDto) {
        Long districtId = objDto.getDistrictId();
        District district = streetService.getDistrictById(districtId);

        Street obj = streetService.fromDto(objDto, district);
        obj = streetService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody StreetDTO objDto) {
        Street obj = streetService.fromDto(objDto);
        obj.setId(id);
        obj = streetService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
