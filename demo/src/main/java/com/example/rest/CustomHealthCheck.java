/*package com.example.rest;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomHealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String response = restTemplate.getForObject("http://localhost:9001/admin/health", String.class);

			if (response != null) {
				return Health.up().withDetail("UP", "Demo Component Service is up and running").build();
			} else {
				return Health.down().withDetail("DOWN", "Demo Component Service is down").build();
			}
		} catch (Exception e) {
			return Health.down().withDetail("DOWN", "Demo Component Service is Non Working").build();
		}

	}

}
*/