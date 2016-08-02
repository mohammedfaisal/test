package com.faisal.project.weather.client.view;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.project.weather.client.model.City;
import com.faisal.project.weather.client.service.WeatherClientService;

@RestController
@EnableAutoConfiguration
public class TestController {
	
	@Autowired private WeatherClientService weatherClientService;
	
	@PostConstruct
	public void init(){
		System.err.println("Initailizing Test Controller");
	}
	
	@RequestMapping("/index")
	public String home(@RequestParam(value="zip", required=true) String zip){
		
		weatherClientService.send(zip);
		
		List<City> cities = weatherClientService.getCities();
		for(City c : cities){
			System.err.println(c.toString());
		}
		
		return "Hello World";
	}
	
}
