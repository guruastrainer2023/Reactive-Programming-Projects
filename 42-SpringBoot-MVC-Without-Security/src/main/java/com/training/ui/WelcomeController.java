package com.training.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public ModelAndView f1() {
		ModelAndView mav=new ModelAndView("welcome","message","Welcome to Spring MVC Without Security");
		return mav;
	}
	
	@RequestMapping("/greet")
	public ModelAndView f2() {
		ModelAndView mav=new ModelAndView("greet","message","Hello How are you?");
		return mav;
	}   
}
