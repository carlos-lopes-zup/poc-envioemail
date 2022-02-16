package com.envioemail.zup.envioemailpoc.config;

import com.envioemail.zup.envioemailpoc.service.EmailService;
import com.envioemail.zup.envioemailpoc.service.MockEmailService;
import com.envioemail.zup.envioemailpoc.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}
