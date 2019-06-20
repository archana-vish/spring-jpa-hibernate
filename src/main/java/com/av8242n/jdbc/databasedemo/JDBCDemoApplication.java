package com.av8242n.jdbc.databasedemo;

import com.av8242n.jdbc.databasedemo.entity.Person;
import com.av8242n.jdbc.databasedemo.jdbc.PersonDAOJdbc;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import java.util.Date;


// Use this when you want to check out jdbc queries
public class JDBCDemoApplication {

    @Autowired
    PersonDAOJdbc personDAOJdbc;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(JDBCDemoApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(DatabaseDemoApplication.class, args);
    }


    public void run(String... args) throws Exception {
        logger.info("Person findAll ::  {} ", personDAOJdbc.findAll());
        logger.info("Person by Id   ::  {} ", personDAOJdbc.findById(10001));
        logger.info("Person by loc  ::  {} ", personDAOJdbc.findByLocation("london"));
        logger.info("Delete by Id   ::  {} ", personDAOJdbc.deleteById(10002));

        Person person = new Person(10005, "sven", "carrotLand", new Date());
        logger.info("Inserting {} " , personDAOJdbc.insert(person));
        logger.info("Update {} " , personDAOJdbc.update(10003, person));



    }
}
