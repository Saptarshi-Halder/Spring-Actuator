package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;

@Endpoint(id = "loggers")
public class LoggersEndPoint {
	
	@Autowired
	LoggingSystem loggingSystem;
	
	public void getLogLevel(@Selector String name, LogLevel configuredLevel) {
		this.loggingSystem.setLogLevel(name, configuredLevel);
	}

}
