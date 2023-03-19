package com.filter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFilterApplication.class, args);
	}

}
