package com.blorferind.rentalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.blorferind.repository")
@SpringBootApplication
@EntityScan(basePackages = "com.blorferind")
@ComponentScan(basePackages = "com.blorferind")
public class RentalserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalserviceApplication.class, args);
	}

}
