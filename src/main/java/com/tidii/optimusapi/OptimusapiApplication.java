package com.tidii.optimusapi;

import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.repositories.DistrictRepository;
import com.tidii.optimusapi.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OptimusapiApplication implements CommandLineRunner {

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private StreetRepository streetRepository;

	public static void main(String[] args) {
		SpringApplication.run(OptimusapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		District district1 = new District(null, "District 1", "Normal activity", false);
		District district2 = new District(null, "District 2", "Normal activity", false);

		Street street1 = new Street(null, "Street 1", "Normal activity", false, district1);
		Street street2 = new Street(null, "Street 2", "Normal activity", false, district1);
		Street street3 = new Street(null, "Street 3", "Normal activity", false, district2);
		Street street4 = new Street(null, "Street 4", "Normal activity", false, district2);

		district1.setStreets(Arrays.asList(street1, street2));
		district2.setStreets(Arrays.asList(street3, street4));

		districtRepository.saveAll(Arrays.asList(district1, district2));
		streetRepository.saveAll(Arrays.asList(street1, street2, street3, street4));
	}
}
