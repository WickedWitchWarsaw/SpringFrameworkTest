package com.wickedwitch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by ZuZ on 2016-12-31.
 */
public class SmptEmailService extends AbstractEmailService {

    @Autowired
    private MailSender mailSender;

    public static final Logger LOG = LoggerFactory.getLogger(SmptEmailService.class);

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        LOG.debug("Sending message for {}", message);
        mailSender.send(message);
        LOG.info("Email SENT...");

    }
}
