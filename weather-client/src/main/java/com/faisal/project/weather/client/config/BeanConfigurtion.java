package com.faisal.project.weather.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * <p>Bean configuration definitions
 * 
 * @author Mohammed.Faisal
 */
@Configuration
public class BeanConfigurtion {
	
	@Bean
	public Jaxb2Marshaller getJaxb2Marshaller(){
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("com.faisal.project.wheather.client.wsdl.model");
		System.err.println("Jaxb2Marshaller bean generated");
		return jaxb2Marshaller;
	}
	
}
