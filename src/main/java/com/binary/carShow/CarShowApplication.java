package com.binary.carShow;

import com.binary.carShow.entity.Car;
import com.binary.carShow.entity.Owner;
import com.binary.carShow.entity.User;
import com.binary.carShow.repository.CarRepository;
import com.binary.carShow.repository.OwnerRepository;
import com.binary.carShow.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication

	//@SpringBootApplication is this three (below) in one. Can call just thta one, or all three

//@EnableAutoConfiguration		//detects the type of app you are making and it applies it to your structure (depends on the dependency injections)
//@ComponentScan				//enables the Spring Boot component scan to find all of the components in the app
//@Configuration				//used to define  a configuration class that provides beans in the Spring Boot app

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {

	@Autowired		//keyword for it to be injected
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;		//inject the owner repository

	//Security!!
	@Autowired
	private UserRepository userRepository;


	private static final Logger logger = LoggerFactory.getLogger(CarShowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner = new Owner("John", "Doe");			//create
		Owner owner2 = new Owner("Jack", "Black");
		ownerRepository.save(owner);		//saving witht the CRUD Repsoitoyry inside ownerRepository
		ownerRepository.save(owner2);

		List<Car> cars = Arrays.asList(
				new Car("Ford", "Lighting", "Gray","FL-234",2023,75000,owner),
				new Car("Nissan", "Leaf", "Green","8FG-345",2022,40000,owner2),
				new Car("Toyota", "Sienna", "Silver","CDF-233",2024,60000,owner2),
				new Car("Honda", "Accord", "Whitey","HW-345",2024,57000,owner)
		);
		carRepository.saveAll(cars);		//.saveAll is part of the CURDRepository we are extending on carRepository and let manipulate the SQL

		carRepository
				.findAll()
				.forEach(car->logger.info(car.getMake()+" "+ car.getModel()));

		ownerRepository
				.findAll()					//.findAll will show all the cars on the list
				.forEach(ow -> logger.info(ow.getFirstName()));

//----------------------------------------------------------------------------
		// SECURITY

		userRepository.save(new User("user", "$2y$12$Ze.Piikopw4og0jYRM3aCO9WUYrdFXPzdBElZ5pe5f55CGXkOS9GC", "USER"));
		userRepository.save(new User("admin","$2y$12$7A1GXnAqDn9g.f3sFa3LCeOGVJrR6JOwGh3roWIyIRuAx.OLPgdzG" ,"ADMIN"));

//-----------------------------------------------------------


	}

	//ORM (Object Relational Mapping) : is a technique that allows you to fetch from and manipulate a database
		//by using OOP paradigm.		(able to make tables directly and convert them to objects to manipulate it. back and forth)
			// We do this with Hibernate!! ( the implementation of ORM)
				// class Book (id,title,author,price) -> Table Book (id,title,author,price)
					// entity -> table

	//JPA (Java Persistent API): specification for managing relational data in applications.
		// It provides a programming interface for managing relational data in Java applications using object-relational mapping (ORM)
		// techniques. JPA allows developers to map Java objects to database tables, making it easier to interact with databases using
		// Java code.

	//Entity: Class with the implementation structure of a table. To create them





}
