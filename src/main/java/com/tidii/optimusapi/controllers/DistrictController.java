package com.tidii.optimusapi.controllers;

import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/districts")
public class DistrictController {

    @GetMapping
    public List<District> find() {
        District district1 = new District(null, "District 1", "Normal activity", false);
        Street street1 = new Street(null, "Street 1", "Normal activity", false, district1);
        Street street2 = new Street(null, "Street 2", "Normal activity", false, district1);

        District district2 = new District(null, "District 2", "Normal activity", false);
        Street street3 = new Street(null, "Street 3", "Normal activity", false, district2);
        Street street4 = new Street(null, "Street 4", "Normal activity", false, district2);

        List<Street> streets1 = new ArrayList<>();
        streets1.addAll(Arrays.asList(street1, street2));

        List<Street> streets2 = new ArrayList<>();
        streets2.addAll(Arrays.asList(street3, street4));

        district1.setStreets(streets1);
        district2.setStreets(streets2);

        List<District> list = new ArrayList<>();
        list.addAll(Arrays.asList(district1, district2));

        return list;
    }
}
