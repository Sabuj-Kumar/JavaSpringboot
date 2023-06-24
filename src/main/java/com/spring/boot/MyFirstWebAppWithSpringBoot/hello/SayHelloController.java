package com.spring.boot.MyFirstWebAppWithSpringBoot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String hello(){
		
		return "hello what are you learning today";
	}
	
	@RequestMapping("say-hello-html")
	public String sayHello(){
		
		return "hello";
	}
}
