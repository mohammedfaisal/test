package com.faisal.project.weather.client.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginViewController extends BaseViewController{
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
}
