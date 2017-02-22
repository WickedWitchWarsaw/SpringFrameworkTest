package com.wickedwitch.service;

import com.wickedwitch.pojo.Person;
import com.wickedwitch.repositories.PersonInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ZuZ on 2017-01-29.
 */
@Service
public class PersonServiceDB implements PersonInterface {
    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceDB.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        LOG.info("Creating table...");

        jdbcTemplate.execute("DROP TABLE PersonData IF EXISTS");
        jdbcTemplate.execute
                ("CREATE TABLE PersonData(id SERIAL, firstname VARCHAR(255), lastname VARCHAR(255), email VARCHAR(255), username VARCHAR(255), password VARCHAR(255), added TIMESTAMP)");

        LOG.info("Inserting data...");

        String sql1 = "INSERT INTO PersonData(firstname, lastname, email, username, password, added) " +
                "VALUES('FnOne', 'LnOne', 'one@xxx.pl', 'userone', 'pass1', '2017-01-29 00:00:00.00' )";

        jdbcTemplate.execute(sql1);

        jdbcTemplate.execute("INSERT INTO PersonData(firstname, lastname, email, username, password, added) " +
                "VALUES('FnTwo', 'LnTwo', 'two@zzz.pl', 'usertwo', 'pass2', '2017-01-26 00:00:00.00')");
        jdbcTemplate.execute("INSERT INTO PersonData(firstname, lastname, email, username, password, added) " +
                "VALUES('FnThree', 'LnThree', 'three@zzz.pl', 'userthree', 'pass3', '2017-01-29 00:00:00.00')");
        jdbcTemplate.execute("INSERT INTO PersonData(firstname, lastname, email, username, password, added) " +
                "VALUES('FnFour', 'LnFour', 'four@xxx.pl', 'userfour', 'pass4', '2017-01-28 00:00:00.00')");
        jdbcTemplate.execute("INSERT INTO PersonData(firstname, lastname, email, username, password, added) " +
                "VALUES('FnFive', 'LnFour', 'five@zzz.pl', 'userfive', 'pass5', '2017-01-27 00:00:00.00')");
        jdbcTemplate.execute("INSERT INTO PersonData(firstname, lastname, email, username, password, added) " +
                "VALUES('FnSix', 'LnSix', 'six@zzz.pl', 'usersix', 'pass6', '2017-01-29 00:00:00.00')");

        LOG.info("Completed.");

    }


    @Override
    public List<Person> findAll() {
        List<Person> entries = new ArrayList<>();

        jdbcTemplate.query("SELECT * FROM PersonData",
                new Object[]{}, (rs, row) -> new Person(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        new Date(rs.getTimestamp("added").getTime())))
                .forEach(entry -> entries.add(entry));

        return entries;
    }

}
