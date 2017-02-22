package com.wickedwitch;

import com.wickedwitch.service.PersonServiceDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFrameworkTestApplication implements CommandLineRunner {

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(SpringFrameworkTestApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringFrameworkTestApplication.class, args);
	}

	@Autowired
	private PersonServiceDB personServiceDB;

	@Override
	public void run(String... args) throws Exception {
		LOG.info("@@Inserting Data...");
		personServiceDB.insertData();
		LOG.info("@@FindAll method invoked...");
		personServiceDB.findAll().forEach(entry -> LOG.info(entry.toString()));

	}
}
