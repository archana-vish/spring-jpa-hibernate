package com.av8242n.jdbc.databasedemo.jpa;


import com.av8242n.jdbc.databasedemo.entity.Person;
import com.av8242n.jdbc.databasedemo.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJPARepository {


    // Connect to the database
    @PersistenceContext
    EntityManager entityManager;


    public PersonEntity findById(int id) {
       return entityManager.find(PersonEntity.class, id);
    }
}
