package com.spring.restaurant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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
		/*
		http.authorizeRequests().anyRequest().denyAll()
        .and().formLogin().and().httpBasic();
		*/
		
		http.authorizeRequests()
		.antMatchers("/football/*").authenticated()
		.antMatchers("/basketball/*").authenticated()
		.antMatchers("/subscribers/*").authenticated()
		.antMatchers("/swimming/*").authenticated()
		.antMatchers("/about/*").permitAll()
		.antMatchers("/connect/*").permitAll()
	    .and().formLogin().and().httpBasic();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("slimen").password("12345").authorities("admin")
			.and().withUser("test").password("00000").authorities("player")
			 .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}

}
