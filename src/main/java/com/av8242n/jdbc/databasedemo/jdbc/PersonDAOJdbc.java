package com.av8242n.jdbc.databasedemo.jdbc;

        import com.av8242n.jdbc.databasedemo.entity.Person;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public class PersonDAOJdbc {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // select * from person;
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
    }
}
