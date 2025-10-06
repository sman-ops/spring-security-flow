package com.spring.restaurant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.authorizeRequests((requests) ->
		requests.anyRequest().authenticated());
		http.formLogin();
		http.httpBasic(); 
		
		*/
		/*
		  http.authorizeRequests().anyRequest().permitAll()
        .and().formLogin().and().httpBasic();  */
		
		http.authorizeRequests()
		.antMatchers("/football/start").authenticated()
		.antMatchers("/basketball/start").authenticated()
		.antMatchers("/subscribers/start").authenticated()
		.antMatchers("/swimming/start").authenticated()
		.antMatchers("/about/start").permitAll()
		.antMatchers("/connect/start").permitAll()
	    .and().formLogin().and().httpBasic();
		
	}

}
