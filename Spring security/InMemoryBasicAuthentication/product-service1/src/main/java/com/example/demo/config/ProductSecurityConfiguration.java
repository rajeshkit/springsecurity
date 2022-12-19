package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProductSecurityConfiguration {

	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	  throws Exception { 
		return http.csrf().disable()
		.authorizeHttpRequests(auth->{
		 
	  auth.antMatchers(HttpMethod.GET,"/products/*").hasRole("user");
	  auth.antMatchers("/products/*").hasRole("admin"); //
	  auth.anyRequest().authenticated();//authentication
	  }).httpBasic(Customizer.withDefaults()) .build();
	  
	  }

	@Bean 
	InMemoryUserDetailsManager users() 
	{ 
	return new InMemoryUserDetailsManager(
			User
			.withUsername("rajesh")
			.password("{noop}rajesh")
			.roles("user")
			.build(),
			User.withUsername("kavin")
			.password("kavin")
			.roles("{noop}admin")
			.build());
	  
	  }

}// role based access
