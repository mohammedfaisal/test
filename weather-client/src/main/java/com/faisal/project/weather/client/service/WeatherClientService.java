package com.faisal.project.weather.client.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.faisal.project.weather.client.model.City;
import com.faisal.project.weather.client.repository.CityRepository;
import com.faisal.project.wheather.client.wsdl.model.Forecast;
import com.faisal.project.wheather.client.wsdl.model.GetCityForecastByZIP;
import com.faisal.project.wheather.client.wsdl.model.GetCityForecastByZIPResponse;

@Service
public class WeatherClientService extends WebServiceGatewaySupport{
	
	@Autowired private Jaxb2Marshaller jaxb2Marshaller;
	@Autowired private CityRepository cityRepository;
	
	@PostConstruct
	public void init(){
		this.setMarshaller(jaxb2Marshaller);
		this.setUnmarshaller(jaxb2Marshaller);
	}
	
	
	public GetCityForecastByZIPResponse send(String zip){
		
		System.err.println("Sending request");
		
		GetCityForecastByZIP request = new GetCityForecastByZIP();
		request.setZIP(zip);
		
		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate().marshalSendAndReceive("http://wsf.cdyne.com/WeatherWS/Weather.asmx", request,
				new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));
		
		System.err.println("Response Text : "+response.getGetCityForecastByZIPResult().getResponseText());
		System.err.println("State : "+response.getGetCityForecastByZIPResult().getState());
		System.err.println("City : "+response.getGetCityForecastByZIPResult().getWeatherStationCity());
		
		for(Forecast forecast : response.getGetCityForecastByZIPResult().getForecastResult().getForecast()){
			System.err.println("Description : "+forecast.getDesciption());
			System.err.println("Temperature : "+forecast.getTemperatures().getDaytimeHigh());
		}
		return response;
	}
	
	public List<City> getCities(){
		return cityRepository.findAll();
	}
	
}
