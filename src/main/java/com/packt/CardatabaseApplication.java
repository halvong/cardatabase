package com.packt;

import com.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
	
	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository orepository;
	@Autowired
	private UserRepository urepository;


	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(CardatabaseApplication.class, args);

		logger.info("Hello Spring Boot. Postgresql cardatabase. From Hal!");



	}

	@Bean
	CommandLineRunner runner() {

		return args -> {

		    Owner owner1 = new Owner("John","Chang");
			Owner owner2 = new Owner("Mary","Robinson");
			Owner owner3 = new Owner("David","Carroll");
			Owner owner4 = new Owner("Peter","Gabriel");
			orepository.save(owner1);
			orepository.save(owner2);
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59022, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29500, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 3900, owner1));

			// username: user password: user
			urepository.save(new User("user", "password2", "USER"));
			// username: admin password: admin
			urepository.save(new User("admin", "password1", "ADMIN"));

			//orepository.save(owner3);
			//orepository.save(owner4);
			//repository.save(new Car("Honda", "Accord", "Pearl", "K84913A", 2018, 390, owner3));
			//repository.save(new Car("Mazda", "M3", "Red", "GCA912", 2017, 15590, owner3));
			//repository.save(new Car("Chevrolet", "Malibu", "Brown", "HAL3905R", 1999, 195590, owner4));
			//repository.save(new Car("Chrysler", "Jeep", "Blue", "99AL35Q", 2016, 25822, owner4));
		};
	}

}//class
