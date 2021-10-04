package com.tidii.optimusapi.controllers;

import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/streets")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Street> find(@PathVariable Long id) {
        Street obj = streetService.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
