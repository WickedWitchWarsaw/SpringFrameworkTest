package com.wickedwitch.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by ZuZ on 2017-02-25.
 */
@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String eventName;
    private String description;
    private Date dateAdded;

    @Transient
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public Event(String eventName, String description, String dateAdded) throws ParseException {
        this.id = id;
        this.eventName = eventName;
        this.description = description;
        this.dateAdded = dateFormat.parse(dateAdded);
    }

    public Event(){}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(id);
        sb.append(", eventName='").append(eventName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", dateAdded=").append(dateAdded);
        sb.append('}');
        return sb.toString();
    }
}
