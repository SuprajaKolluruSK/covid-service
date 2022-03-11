package com.covid.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true )
public class country {

	All all;
	State state;
	public All getAll() {
		return all;
	}
	public void setAll(All all) {
		this.all = all;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
	
}
