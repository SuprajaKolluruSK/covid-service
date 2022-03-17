package com.covid.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

	Logger logger = LoggerFactory.getLogger(ServiceLayer.class);

	Map<String, Double> vaccine = new HashMap<String, Double>();
	Map<String, Double> deathsOfcountry = new HashMap<String, Double>();
     int countries=0;

     /*Calculates the sum of percentage of vaccinated people in a continent*/
	/*Calculates the sum of y in the formula*/
	public double vaccinated(Map<String, Map<String, Map<String, Object>>> input) {
		double sumofVaccinated = 0.0;

		 countries = input.keySet().size();

			logger.info("Fetching the sum of vaccinated people");

	try {		
		for (Map.Entry<String, Map<String, Map<String, Object>>> vaccineEntry : input.entrySet()) {
			if (vaccineEntry.getValue().get(Constants.ALL) != null) {
				Map<String, Object> allEntry = vaccineEntry.getValue().get(Constants.ALL);

				if (allEntry.get(Constants.VACCINATED) != null && allEntry.get(Constants.POPULATION) != null) {
					Object vaccinatedperCountry = allEntry.get(Constants.VACCINATED);

					int castToVaccinated = (int) (vaccinatedperCountry);
					double vaccinated = (double) castToVaccinated;
					double percentage = 0.0;
					Object populationOfCountry = allEntry.get(Constants.POPULATION);
					if (populationOfCountry instanceof Integer) {

						int castToPopulation = (int) (populationOfCountry);
						double population = (double) castToPopulation;

						percentage = percentage(vaccinated,population);
					} else {

						long castToPopulation = (long) (populationOfCountry);
						double population = (double) castToPopulation;
						percentage = percentage(vaccinated,population);
					}
					vaccine.put(vaccineEntry.getKey(), percentage);

					sumofVaccinated = sumofVaccinated + percentage;
				}

			}

		}
	}catch(Exception e) {
		logger.error("Error while caculating the vaccinated people"+e.getClass());

		
	}
		return sumofVaccinated;
		
	}
	
    /*Calculates the sum of percentage of death in a continent*/
	/*Calculates the sum of x in the formula*/

	
	public double deaths(Map<String, Map<String, Map<String, Object>>> input) {
		double sumOfDeaths = 0.0;

		logger.info("Fetching the sum of death people");

		try {
			for (Map.Entry<String, Map<String, Map<String, Object>>> entry : input.entrySet()) {
				if (entry.getValue().get(Constants.ALL) != null) {
					Map<String, Object> allEntry = entry.getValue().get(Constants.ALL);

					if (allEntry.get(Constants.DEATHS) != null && allEntry.get(Constants.POPULATION) != null) {
						Object deathsOfCountry = allEntry.get(Constants.DEATHS);

						int castToDeaths = (int) (deathsOfCountry);
						double deaths = (double) castToDeaths;
						double percentage = 0.0;
						Object populationOfCountry = allEntry.get(Constants.POPULATION);
						if (populationOfCountry instanceof Integer) {

							int castToPopulation = (int) (populationOfCountry);
							double population = (double) castToPopulation;

							percentage = (deaths / population) * 100;
						} else {

							long castToPopulation = (long) (populationOfCountry);
							double population = (double) castToPopulation;
							percentage = (deaths / population) * 100;

						}
						deathsOfcountry.put(entry.getKey(), percentage);

						sumOfDeaths = sumOfDeaths + percentage;
					}

				}

			}
		}
		catch(Exception e){
			
			logger.error("Error while caculating the vaccinated people"+e.getClass());
		}
		return sumOfDeaths;
		
	}
	
	public String productCalculation(double sumofDeaths,double sumofVaccinated) {
		
		Set<String> deathkey = deathsOfcountry.keySet();
		double product = 0.0;
		double sumOfDeathsandVaccinated = 0.0;
		double productOfDeaths = 0.0;
		double productOfVaccine = 0.0;
		double sumofDeathsProduct = 0.0;
		double sumOfVaccinatedProduct = 0.0;

		for (String name : deathkey) {
			if (deathsOfcountry.get(name) != null && vaccine.get(name) != null) {
				product = deathsOfcountry.get(name) * vaccine.get(name);
				sumOfDeathsandVaccinated = sumOfDeathsandVaccinated + product;//sum of product x and y
				productOfDeaths = deathsOfcountry.get(name) * deathsOfcountry.get(name);
				sumofDeathsProduct = sumofDeathsProduct + productOfDeaths;//sum of product of x
				productOfVaccine = vaccine.get(name) * vaccine.get(name);
				sumOfVaccinatedProduct = sumOfVaccinatedProduct + productOfVaccine;//sum of product of y
			}
		}
		double coefficient = coefficient(sumofDeaths,sumofVaccinated,sumOfDeathsandVaccinated,countries,sumofDeathsProduct,sumOfVaccinatedProduct);

		String result =  String.valueOf(coefficient);


		return result;
		

	}
	
	
     public double percentage(double deaths,double population) {
		
		return (deaths/population)*100;
		
	}
     
 	/*calculates the correlation coefficient of a continent */

	public double coefficient(double sumofDeaths,double sumofVaccinated,double sumOfDeathsandVaccinated,int countries
			,double sumofDeathsProduct,double sumOfVaccinatedProduct) {
		
		double country =  countries;
		double numerator = (countries*sumOfDeathsandVaccinated) - (sumofDeaths*sumofVaccinated);
		double denominator1 = (country*sumofDeathsProduct)-(sumofDeaths*sumofDeaths);
		double denominator2 = (country*sumOfVaccinatedProduct)-(sumofVaccinated*sumofVaccinated);
		double denominator3 = denominator1*denominator2;

		double result =  numerator/Math.sqrt(denominator3);
		
		return result;
	}

	
}
