package com.covid.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.covid.resource.Service;

@SpringBootApplication
public class ResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	
	@Bean
	   public Service service() {
	      return new Service();
	   }
}
