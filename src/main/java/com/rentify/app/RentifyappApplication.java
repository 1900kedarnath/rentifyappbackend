package com.rentify.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class RentifyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentifyappApplication.class, args);
	}

}
