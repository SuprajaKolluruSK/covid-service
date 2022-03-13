package com.covid.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController

public class Controller {
	
	Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Service service;

	@GetMapping(value = "/src")

	public ResponseEntity<String> covid(@RequestParam(required = false) String continent) {

		double sumOfVaccinated = 0.0;
		double sumOfDeaths = 0.0;
		Map<String, Map<String, Map<String, Object>>> deathsInfo = restTemplate
				.getForObject("https://covid-api.mmediagroup.fr/v1/cases?continent=" + continent, Map.class);
		Map<String, Map<String, Map<String, Object>>> vaccinatedInfo = restTemplate
				.getForObject("https://covid-api.mmediagroup.fr/v1/vaccines?continent=" + continent, Map.class);

		if(deathsInfo!=null && vaccinatedInfo!=null && !deathsInfo.isEmpty() && !vaccinatedInfo.isEmpty()) {
			 sumOfVaccinated = service.vaccinated(vaccinatedInfo);
			 sumOfDeaths = service.deaths(deathsInfo);
		}else{
			logger.info("No data found");
			return ResponseEntity.notFound().build();
		}


		return ResponseEntity.ok().body(service.productCalculation(sumOfDeaths, sumOfVaccinated));

	}

	
	
	
	
}
