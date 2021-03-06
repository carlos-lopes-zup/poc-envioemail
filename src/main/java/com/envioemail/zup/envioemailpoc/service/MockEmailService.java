package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage sms) {
        LOG.info("Simulando envio de email!");
        LOG.info(sms.toString());
        LOG.info("Email enviado com sucesso");
    }

    @Override
    public void sendHtmlEmail(MimeMessage sms) {
        LOG.info("Simulando envio de email!");
        LOG.info(sms.toString());
        LOG.info("Email enviado com sucesso");
    }

}
