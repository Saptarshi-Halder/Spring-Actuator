package com.example.rest;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.env.EnvironmentEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.requestMatchers(EndpointRequest.to(InfoEndpoint.class)).fullyAuthenticated()
		.requestMatchers(EndpointRequest.to(EnvironmentEndpoint.class)).fullyAuthenticated()
		.and().httpBasic();

	}
}
