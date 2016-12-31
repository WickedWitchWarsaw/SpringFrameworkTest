package com.wickedwitch.controller;

import com.wickedwitch.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by ZuZ on 2016-12-25.
 */

@Controller
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping("/form")
    public String showForm(Model model) {

        Person person = new Person();
        model.addAttribute("person", person);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public void formPost(@ModelAttribute("person") Person person) {
        LOG.info("Adding person details {}", person);

    }
}
