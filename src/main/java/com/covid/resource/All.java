package com.covid.resource;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true )
public class All {

	private Integer confirmed;
	private Integer recovered;
	private Integer deaths;
	private String country;
	private Integer population;
	private Integer sqKmArea;
	private String lifeExpectancy;
	private Object elevationInMeters;
	private String continent;
	private String abbreviation;
	private String location;
	private Integer iso;
	private String capitalCity;
	private String lat;
	private String _long;
	private String updated;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getConfirmed() {
	return confirmed;
	}

	public void setConfirmed(Integer confirmed) {
	this.confirmed = confirmed;
	}

	public Integer getRecovered() {
	return recovered;
	}

	public void setRecovered(Integer recovered) {
	this.recovered = recovered;
	}

	public Integer getDeaths() {
	return deaths;
	}

	public void setDeaths(Integer deaths) {
	this.deaths = deaths;
	}

	public String getCountry() {
	return country;
	}

	public void setCountry(String country) {
	this.country = country;
	}

	public Integer getPopulation() {
	return population;
	}

	public void setPopulation(Integer population) {
	this.population = population;
	}

	public Integer getSqKmArea() {
	return sqKmArea;
	}

	public void setSqKmArea(Integer sqKmArea) {
	this.sqKmArea = sqKmArea;
	}

	public String getLifeExpectancy() {
	return lifeExpectancy;
	}

	public void setLifeExpectancy(String lifeExpectancy) {
	this.lifeExpectancy = lifeExpectancy;
	}

	public Object getElevationInMeters() {
	return elevationInMeters;
	}

	public void setElevationInMeters(Object elevationInMeters) {
	this.elevationInMeters = elevationInMeters;
	}

	public String getContinent() {
	return continent;
	}

	public void setContinent(String continent) {
	this.continent = continent;
	}

	public String getAbbreviation() {
	return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
	this.abbreviation = abbreviation;
	}

	public String getLocation() {
	return location;
	}

	public void setLocation(String location) {
	this.location = location;
	}

	public Integer getIso() {
	return iso;
	}

	public void setIso(Integer iso) {
	this.iso = iso;
	}

	public String getCapitalCity() {
	return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
	this.capitalCity = capitalCity;
	}

	public String getLat() {
	return lat;
	}

	public void setLat(String lat) {
	this.lat = lat;
	}

	public String getLong() {
	return _long;
	}

	public void setLong(String _long) {
	this._long = _long;
	}

	public String getUpdated() {
	return updated;
	}

	public void setUpdated(String updated) {
	this.updated = updated;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	
}
