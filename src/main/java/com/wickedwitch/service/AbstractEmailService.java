package com.wickedwitch.service;


import com.wickedwitch.pojo.Feedback;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by ZuZ on 2016-12-31.
 */
public abstract class AbstractEmailService implements EmailService {

    protected SimpleMailMessage prepareSimpleMailMessageFromFeedback(Feedback feedback){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("wickedwitchwarsaw@gmail.com");
        message.setFrom(feedback.getEmail());
        message.setSubject("Feedback - " + feedback.getFirstName());
        message.setText(feedback.getFeedback());
        return message;
    }



    @Override
    public void sendFeedbackEmail(Feedback feedback) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedback(feedback));
    }
}
