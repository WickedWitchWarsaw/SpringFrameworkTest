package com.wickedwitch.config;

import com.wickedwitch.service.EmailService;
import com.wickedwitch.service.SmptEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by ZuZ on 2016-12-31.
 */

@Configuration
@PropertySource("application.properties")
public class EmailConfig {
    @Bean
    public EmailService emailService(){
        return new SmptEmailService();
    }
}
