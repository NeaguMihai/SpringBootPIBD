package com.proiectpibd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.neagumihai.proiectpibddata.service",
											"com.neagumihai.proiectpibddata.repositories",
											"com.proiectpibd",
											"com.proiectpibd.config"})
@EnableJpaRepositories(basePackages = {"com.neagumihai.proiectpibddata.repositories"})
@EntityScan(basePackages = {"com.neagumihai.proiectpibddata.model"})
public class ProiectPibdWebApplication{

	public static void main(String[] args) {
		SpringApplication.run(ProiectPibdWebApplication.class, args);
	}

}
