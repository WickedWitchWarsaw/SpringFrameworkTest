package com.wickedwitch.repositories;

import com.wickedwitch.pojo.Person;

import java.util.List;

/**
 * Created by ZuZ on 2017-01-29.
 */
public interface PersonInterface {
    List<Person> findAll();
}
