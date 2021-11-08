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

	public static void main(String[] args) {
		SpringApplication.run(OptimusapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
