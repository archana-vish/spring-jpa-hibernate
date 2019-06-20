package com.av8242n.jdbc.databasedemo;

import com.av8242n.jdbc.databasedemo.entity.Person;
import com.av8242n.jdbc.databasedemo.entity.PersonEntity;
import com.av8242n.jdbc.databasedemo.jdbc.PersonDAOJdbc;
import com.av8242n.jdbc.databasedemo.jpa.PersonJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJPARepository personJPARepository;

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Find person with id 10001 {} ", personJPARepository.findById(10001));

		PersonEntity person = new PersonEntity("sven", "carrotLand", new Date());
		logger.info("Inserting {} " , personJPARepository.ifPresentThenInsertElseUpdate(person));
		person = new PersonEntity(10003, "sven", "carrotyLand", new Date());
		logger.info("Update {} " , personJPARepository.ifPresentThenInsertElseUpdate(person));
	}


}
