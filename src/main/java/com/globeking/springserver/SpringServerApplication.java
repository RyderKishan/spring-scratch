package com.globeking.springserver;

import com.globeking.springserver.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringServerApplication {

	ApplicationConfig applicationConfig;

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", applicationConfig.getEnableDevTools());
		SpringApplication.run(SpringServerApplication.class, args);
	}

}
