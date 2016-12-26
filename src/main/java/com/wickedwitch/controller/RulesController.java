package com.wickedwitch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZuZ on 2016-12-26.
 */

@Controller
public class RulesController {

    @RequestMapping("/rules")
    public String showRules(){
        return "rules";
    }
}
