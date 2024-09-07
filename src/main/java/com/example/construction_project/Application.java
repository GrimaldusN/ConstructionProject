package com.example.construction_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.construction_project.security")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
