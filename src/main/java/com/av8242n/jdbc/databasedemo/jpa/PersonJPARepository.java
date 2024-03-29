package com.av8242n.jdbc.databasedemo.jpa;


import com.av8242n.jdbc.databasedemo.entity.Person;
import com.av8242n.jdbc.databasedemo.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJPARepository {


    // Connect to the database
    @PersistenceContext
    EntityManager entityManager;


    public PersonEntity findById(int id) {
       return entityManager.find(PersonEntity.class, id);
    }

    // Merge -> to insert and update
    // Checks if the id is present, if yes, update
    // if no then update
    public PersonEntity ifPresentThenInsertElseUpdate(PersonEntity person) {
        return entityManager.merge(person);
    }


    // find and if found delete
    public void findAndDeleteById(int id) {
        PersonEntity person = entityManager.find(PersonEntity.class, id);
        entityManager.remove(person);
    }

    // findAll using JPQL
    public List<PersonEntity> findAll() {
        TypedQuery<PersonEntity> namedQuery = entityManager.createNamedQuery("find_all_person", PersonEntity.class);
        List<PersonEntity> personList = namedQuery.getResultList();
        return personList;
    }
}
