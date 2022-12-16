package com.dilip.springboot.myFirstApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class welcomeController {
	//@Autowired
	//private AuthenticationService authenticationService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value ="/",method =RequestMethod.GET)
	public String gotoLoginPage(ModelMap model) {
		logger.info("entering in method gotoLoginPage");
		model.put("name", getLoggedinUsername());
		
		logger.info("existing  method gotoLoginPage");
		return"welcome";
	}	
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
	
//	@RequestMapping(value ="login",method =RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
//		logger.info("entering in method gotoWelcomePage");
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			logger.info("existing  method gotoWelcomePage");
//			return"welcome";
//		}
//		model.put("errormessage", "Please enter the correct credentials .");
//		return"login";
//		
//		
//	}	

}
