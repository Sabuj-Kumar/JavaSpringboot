package com.spring.boot.MyFirstWebAppWithSpringBoot.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("name")
//public class LoginController {
public class WelcomeController {

	/* private Logger logger = LoggerFactory.getLogger(getClass()); */
	/*
	 * private AuthenticationService authenticationService;
	 * 
	 * public LoginController(AuthenticationService authenticationService) {
	 * super(); this.authenticationService = authenticationService; }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		/*
		 * System.out.println("Request param : "+name); logger.info(name);
		 * logger.debug(name); logger.warn(name); model.put("name", name);
		 */
		model.put("name",getLoggedInUsername());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	// public String login(@RequestParam String name,ModelMap model)
	/*
	 * @RequestMapping(value = "login", method = RequestMethod.GET) public String
	 * login(ModelMap model) {
	 * 
	 * System.out.println("Request param : "+name); logger.info(name);
	 * logger.debug(name); logger.warn(name); model.put("name", name);
	 * 
	 * model.put("name", "Spring boot"); return "welcome"; }
	 */

	/*
	 * @RequestMapping(value="login",method = RequestMethod.POST) public String
	 * welcomePage(@RequestParam String name,@RequestParam String password,ModelMap
	 * model) {
	 * 
	 * System.out.println("Request param : "+name); logger.info(name);
	 * logger.debug(name); logger.warn(name); model.put("name", name);
	 * 
	 * model.put("name", name); model.put("password", password);
	 * 
	 * if(authenticationService.authenticate(name, password)) { return "welcome"; }
	 * 
	 * model.put("errorMassage", "invalid credential! please try again"); return
	 * "login"; }
	 */
}
