package com.spring.boot.MyFirstWebAppWithSpringBoot.configuration;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
  
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails useDetails1 = createNewUser("Sabuj", "dummy");
		UserDetails useDetails2 = createNewUser("Niber", "dummy");
		return new InMemoryUserDetailsManager(useDetails1,useDetails2);
	}
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		=input -> passwordEncoder().encode(input);
		UserDetails useDetails = User
				.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("user","admin")
				.build();
		return useDetails;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
