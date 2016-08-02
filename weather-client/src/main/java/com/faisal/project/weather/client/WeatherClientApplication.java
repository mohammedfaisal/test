package com.faisal.project.weather.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Entry Point
 * 
 * @author Mohammed.Faisal
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class WeatherClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherClientApplication.class);
	}
}
