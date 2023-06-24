package com.spring.boot.MyFirstWebAppWithSpringBoot.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
   public boolean authenticate(String name,String password) {
	   
	   boolean isValidUserName = name.equalsIgnoreCase("sabuj");
	   boolean isValidPassword = password.equalsIgnoreCase("valosele");
	   
	   return isValidUserName && isValidPassword;
   }
}
