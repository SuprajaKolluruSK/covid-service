package com.covid.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController

public class Controller {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Service service;

	@GetMapping(value = "/src")

	public double covid(@RequestParam(required = false) String continent) {

		Map<String, Map<String, Map<country, Object>>> deathsInfo = restTemplate
				.getForObject("https://covid-api.mmediagroup.fr/v1/cases?continent=" + continent, Map.class);
		Map<String, Map<String, Map<country, Object>>> vaccinatedInfo = restTemplate
				.getForObject("https://covid-api.mmediagroup.fr/v1/vaccines?continent=" + continent, Map.class);

		double sumOfVaccinated=  service.vaccinated(vaccinatedInfo);
		double sumOfDeaths = service.deaths(deathsInfo);


		return service.productCalculation(sumOfDeaths, sumOfVaccinated);

	}

	
	
	
	
}
