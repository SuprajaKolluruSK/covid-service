package com.covid.resource;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@AutoConfigureMockMvc

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest

public class ControllerTest {

    Map<String,Map<String, Map<String, Object>>> vaccinated = new HashMap<String, Map<String, Map<String, Object>>>();
	
    @Autowired
    private MockMvc mvc;
    
	
	@Test
	public void covidTest() throws JsonParseException, JsonMappingException, IOException {
	   try {
		mvc.perform(get("/src?continent=Europe")
				      .contentType(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	 
	}
	
}
