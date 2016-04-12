package com.mycompany.project.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Mohammed.Faisal
 *
 */
@Controller
@RequestMapping("/user") 
public class LoginViewController {
	
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request){
		System.err.println("Executing login controller");
		model.addAttribute("user", "Mohammed Faisal");
		return "login";
	}
}
