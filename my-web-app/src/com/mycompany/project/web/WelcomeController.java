package com.mycompany.project.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.project.dao.StudentDao;

@Controller
@RequestMapping("/welcome") 
public class WelcomeController {
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/page")
	public ModelAndView welcome(Model model, HttpServletRequest request){
		System.err.println("Executing welcome controller");
		Long count = studentDao.count();
		return new ModelAndView("welcome", "count", count);
	}
	
}
