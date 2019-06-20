package com.av8242n.jdbc.databasedemo.jdbc;

        import com.av8242n.jdbc.databasedemo.entity.Person;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.RowMapper;
        import org.springframework.stereotype.Repository;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Timestamp;
        import java.util.List;

@Repository
public class PersonDAOJdbc {

    @Autowired
    JdbcTemplate jdbcTemplate;


    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    // select * from person;
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }


    // select * from person where id = ?;
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?",
                new Object[]{id}, new PersonRowMapper());
    }

    // select * from person where location = ?;
    public Person findByLocation(String location) {
        return jdbcTemplate.queryForObject("select * from person where location = ?",
                new Object[]{location}, new PersonRowMapper());
    }

    // delete from person where id = ?;
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id = ?",
                new Object[]{id});
    }

    // insert
    public int insert(Person person) {
        return jdbcTemplate.update(
                "insert into PERSON (id, name, location, birth_date) " +
                        "values (?, ?,?,?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())});
    }

    // update
    public int update(int id, Person person) {
        return jdbcTemplate.update(
                "update  PERSON set " +
                        " name = ?, location = ?, birth_date = ?  where id = ?",
                new Object[]{person.getName(), person.getLocation(), person.getBirthDate(), id});
    }
}
