package com.ccc.vendas.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfiguration {
	@Bean (name = "applicationName")
	public String applicationName() {
		return "Sistemas De Vendas";
	}

}
