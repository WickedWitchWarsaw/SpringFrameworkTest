package com.wickedwitch.service;

import com.wickedwitch.pojo.Event;
import com.wickedwitch.repositories.EventInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by ZuZ on 2017-02-25.
 */
@Service
public class EventServiceDB{

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(EventServiceDB.class);

    @Autowired
    private EventInterface eventInterface;

    public void insestDummyEventData() throws ParseException{
        LOG.info("@@Inserting data in EventDB...");

        Event eventParty = new Event("Party1", "Halloween party", "20/10/2016");
        Event eventConference = new Event("Movie Conference", "Promotion show regarding new movie", "02/02/2017");
        Event eventTraining = new Event("Training Session", "Management training", "01/01/2017");

        eventInterface.save(eventParty);
        eventInterface.save(eventConference);
        eventInterface.save(eventTraining);

        LOG.info("complete...");

    }



    public List<Event> findAll() {
        return eventInterface.findAll();
    }


    public Event findByEventName(String eventName) {
        return eventInterface.findByEventName(eventName);
    }
}
