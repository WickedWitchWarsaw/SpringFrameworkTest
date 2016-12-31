package com.wickedwitch.service;

import com.wickedwitch.pojo.Feedback;
import org.springframework.mail.SimpleMailMessage;


/**
 * Created by ZuZ on 2016-12-30.
 */
public interface EmailService {

    void sendFeedbackEmail(Feedback feedback);

    void sendGenericEmailMessage(SimpleMailMessage message);

}
