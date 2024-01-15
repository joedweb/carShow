package com.binary.carShow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication

	//@SpringBootApplication is this three (below) in one. Can call just thta one, or all three

//@EnableAutoConfiguration		//detects the type of app you are making and it applies it to your structure (depends on the dependency injections)
//@ComponentScan				//enables the Spring Boot component scan to find all of the components in the app
//@Configuration				//used to define  a configuration class that provides beans in the Spring Boot app

@SpringBootApplication
public class CarShowApplication {

	private static final Logger logger = LoggerFactory.getLogger(CarShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);

		logger.info("Application started");
	}

}
