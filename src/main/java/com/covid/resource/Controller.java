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

	public String covid(@RequestParam(required = false) String continent) {

		double sumOfVaccinated = 0.0;
		double sumOfDeaths = 0.0;
		Map<String, Map<String, Map<country, Object>>> deathsInfo = restTemplate
				.getForObject("https://covid-api.mmediagroup.fr/v1/cases?continent=" + continent, Map.class);
		Map<String, Map<String, Map<country, Object>>> vaccinatedInfo = restTemplate
				.getForObject("https://covid-api.mmediagroup.fr/v1/vaccines?continent=" + continent, Map.class);

		if(deathsInfo!=null && vaccinatedInfo!=null) {
			 sumOfVaccinated = service.vaccinated(vaccinatedInfo);
			 sumOfDeaths = service.deaths(deathsInfo);
		}else{
			return "No data found";
		}


		return service.productCalculation(sumOfDeaths, sumOfVaccinated);

	}

	
	
	
	
}
