package com.neagumihai.proiectpibddata.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.neagumihai.proiectpibddata.service")
@EnableJpaRepositories("com.neagumihai.proiectpibddata.repositories")
@EntityScan("com.neagumihai.proiectpibddata.model")
public class TestApp {
}
