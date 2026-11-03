package com.codingshuttle.prod_ready_fearures.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.codingshuttle.prod_ready_fearures.auth.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl")
public class AppConfig {

	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	AuditorAware<String> getAuditorAwareImpl() {
		return new AuditorAwareImpl();
	}
}
