package com.tidii.optimusapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/districts")
public class DistrictController {

    @RequestMapping
    public String test() {
        return "The REST is working";
    }
}
