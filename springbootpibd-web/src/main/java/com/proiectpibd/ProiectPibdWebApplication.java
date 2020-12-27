package com.proiectpibd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.neagumihai.proiectpibddata.service",
											"com.proiectpibd"})
@EnableJpaRepositories(basePackages = {"com.neagumihai.proiectpibddata.repositories"})
@EntityScan(basePackages = {"com.neagumihai.proiectpibddata.model"})
public class ProiectPibdWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectPibdWebApplication.class, args);
	}

}
