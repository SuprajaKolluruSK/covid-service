package com.covid.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest

public class ServiceTest {
	
	@Mock
	private Service mockservice;

	
	@Test
	public void covidTest() throws JsonParseException, JsonMappingException, IOException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    InputStream getLocalJsonFile = new FileInputStream("/Users/suprajak/Desktop/data/covid-service/src/test/resources/vaccinated.json");  

	    Map<String,Map<String, Map<String, Object>>> vacc = objectMapper.readValue(getLocalJsonFile,  new TypeReference<Map<String,Map<String, Map<String, Object>>>>() {});

	   final double vaccinatedSum = 0.198;
	   Mockito.when(mockservice.vaccinated(vacc)).thenReturn(vaccinatedSum);
	   Mockito.when(mockservice.deaths(vacc)).thenReturn(vaccinatedSum);
       
	

	 
	}


}
