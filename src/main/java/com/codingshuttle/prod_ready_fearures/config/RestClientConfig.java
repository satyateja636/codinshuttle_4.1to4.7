package com.codingshuttle.prod_ready_fearures.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
public class RestClientConfig {

	@Value("${employeeService.base.url}")
	private String BASE_URL;

	@Bean
	@Qualifier("employeeRestClient")
	RestClient getEmployeeServiceRestClient() {

		return RestClient.builder().baseUrl(BASE_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
}
