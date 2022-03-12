package com.covid.resource;

import java.util.List;

/*import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL) 
@JsonIgnoreProperties(ignoreUnknown=true )*/

public class covidModel {

	private country country;

	public country getCountry() {
		return country;
	}

	public void setCountry(country country) {
		this.country = country;
	}
	
	/*private String CountryTest;

	public String getCountryTest() {
		return CountryTest;
	}

	public void setCountryTest(String countryTest) {
		CountryTest = countryTest;
	}*/

/*	public List<country> getCountry() {
		return country;
	}

	public void setCountry(List<country> country) {
		this.country = country;
	}*/
	
	
	
}
