package com.faisal.project.weather.client.view;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faisal.project.weather.client.service.WeatherClientService;

@Controller
public class WeatherClientViewController extends BaseViewController{
	
	@Autowired WeatherClientService weatherClientService;
	
	/**
	 * Loads the home page
	 * 
	 * @return
	 */
	@RequestMapping("/home")
	public String home(){
		return "base";
	}
	
	/**
	 * Loads the city forecast page
	 *  
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/forecast/city/view")
	public String viewCityForecast(Model model, @RequestParam(value="zip", required=false) String zip, HttpServletRequest request){
		
		if(zip != null && ! zip.isEmpty()){
			model.addAttribute("forecast", weatherClientService.send(zip));
		}
		
		model.addAttribute("cities", weatherClientService.getCities());
		model.addAttribute("dateformatter", new SimpleDateFormat("EEE, d MMMMM, yyyy"));
		return "cityForecastForm";
	}	
}
