package com.covid.resource;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Service {

	Map<String, Double> vaccine = new HashMap<String, Double>();
	Map<String, Double> deathsOfcountry = new HashMap<String, Double>();
     int countries=0;

	
	public double vaccinated(Map<String, Map<String, Map<country, Object>>> input) {
		double sumofVaccinated = 0.0;

		 countries = input.keySet().size();

		for (Map.Entry<String, Map<String, Map<country, Object>>> vaccineEntry : input.entrySet()) {
			if (vaccineEntry.getValue().get(Constants.ALL) != null) {
				Map<country, Object> allEntry = vaccineEntry.getValue().get(Constants.ALL);

				if (allEntry.get(Constants.VACCINATED) != null && allEntry.get(Constants.POPULATION) != null) {
					Object deaths = allEntry.get(Constants.VACCINATED);

					int deaths1 = (int) (deaths);
					double deaths2 = (double) deaths1;
					double percentage = 0.0;
					Object population = allEntry.get(Constants.POPULATION);
					if (population instanceof Integer) {

						int population1 = (int) (population);
						double population2 = (double) population1;

						percentage = percentage(deaths2,population2);
					} else {

						long population1 = (long) (population);
						double population2 = (double) population1;
						percentage = percentage(deaths2,population2);
					}
					vaccine.put(vaccineEntry.getKey(), percentage);

					sumofVaccinated = sumofVaccinated + percentage;
				}

			}

		}
		return sumofVaccinated;
		
	}
	
	public double deaths(Map<String, Map<String, Map<country, Object>>> input) {
		double sumOfDeaths = 0.0;

		
		for (Map.Entry<String, Map<String, Map<country, Object>>> entry : input.entrySet()) {
			if (entry.getValue().get(Constants.ALL) != null) {
				Map<country, Object> allEntry = entry.getValue().get(Constants.ALL);

				if (allEntry.get(Constants.DEATHS) != null && allEntry.get(Constants.POPULATION) != null) {
					Object deaths = allEntry.get(Constants.DEATHS);

					int deaths1 = (int) (deaths);
					double deaths2 = (double) deaths1;
					double percentage = 0.0;
					Object population = allEntry.get(Constants.POPULATION);
					if (population instanceof Integer) {

						int population1 = (int) (population);
						double population2 = (double) population1;

						percentage = (deaths2 / population2) * 100;
					} else {

						long population1 = (long) (population);
						double population2 = (double) population1;
						percentage = (deaths2 / population2) * 100;

					}
					deathsOfcountry.put(entry.getKey(), percentage);

					sumOfDeaths = sumOfDeaths + percentage;
				}

			}

		}
		return sumOfDeaths;
		
	}
	
	public double productCalculation(double sumofDeaths,double sumofVaccinated) {
		
		Set<String> deathkey = deathsOfcountry.keySet();
		double product = 0.0;
		double sumOfDeathsandVaccinated = 0.0;
		double productofsum = 0.0;
		double productofsum2 = 0.0;
		double sumofDeathsProduct = 0.0;
		double sumOfVaccinatedProduct = 0.0;

		for (String name : deathkey) {
			if (deathsOfcountry.get(name) != null && vaccine.get(name) != null) {
				product = deathsOfcountry.get(name) * vaccine.get(name);
				productofsum = deathsOfcountry.get(name) * deathsOfcountry.get(name);
				sumofDeathsProduct = sumofDeathsProduct + productofsum;
				productofsum2 = vaccine.get(name) * vaccine.get(name);
				sumOfVaccinatedProduct = sumOfVaccinatedProduct + productofsum2;
				sumOfDeathsandVaccinated = sumOfDeathsandVaccinated + product;
			}
		}
		double coefficient = coefficient(sumofDeaths,sumofVaccinated,sumOfDeathsandVaccinated,countries,sumofDeathsProduct,sumOfVaccinatedProduct);

		
		return coefficient;
		
		
		
	}
	
     public double percentage(double deaths,double population) {
		
		return (deaths/population)*100;
		
	}
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