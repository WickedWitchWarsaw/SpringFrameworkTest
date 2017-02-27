package com.wickedwitch;

import com.wickedwitch.service.EventServiceDB;
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

	@Autowired
	private EventServiceDB eventServiceDB;

	@Override
	public void run(String... args) throws Exception {
		personServiceDB.insertData();
		eventServiceDB.insestDummyEventData();
		LOG.info("@@Invoking FindAll method on PersonDB...");
		personServiceDB.findAll().forEach(entry -> LOG.info(entry.toString()));
		LOG.info("@@Invoking FindAllMethod on EventDB...");
		eventServiceDB.findAll().forEach(event -> LOG.info(event.toString()));
		LOG.info("@@FindByEventName on EventDB");
		LOG.info(eventServiceDB.findByEventName("Party1").toString());

	}
}
