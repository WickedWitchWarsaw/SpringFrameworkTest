
package com.wickedwitch.controller;

import com.wickedwitch.pojo.Feedback;
import com.wickedwitch.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZuZ on 2016-12-30.
 */
@Controller
public class FeedbackController {

    @Autowired
    private EmailService emailService;

    private static final Logger LOG = LoggerFactory.getLogger(FeedbackController.class);

    @RequestMapping("/feedback")
    public String showFeedback(Model model){

        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "feedback";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public String postFeedback(@ModelAttribute("feedback") Feedback feedback){
        LOG.info("Feedback form submitted {}", feedback);
        emailService.sendFeedbackEmail(feedback);
        return "feedback";

    }

}
