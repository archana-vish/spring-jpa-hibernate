package com.av8242n.jdbc.databasedemo;

import com.av8242n.jdbc.databasedemo.jdbc.PersonDAOJdbc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	PersonDAOJdbc personDAOJdbc;

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person findAll ::  {} ", personDAOJdbc.findAll());
		logger.info("Person by Id   ::  {} ", personDAOJdbc.findById(10001));
		logger.info("Person by loc  ::  {} ", personDAOJdbc.findByLocation("london"));
	}


}
