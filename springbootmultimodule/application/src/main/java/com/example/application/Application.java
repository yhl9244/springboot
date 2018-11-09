package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Import(ServiceConfiguration.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private Service service;

	@Autowired
	public Application(Service service){
		this.service = service;
	}

	public String home() {
		return service.
	}
}
