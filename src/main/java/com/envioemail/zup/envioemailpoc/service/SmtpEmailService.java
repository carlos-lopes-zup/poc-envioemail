package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import com.envioemail.zup.envioemailpoc.input.dto.OrderRecusedDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SmtpEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(SimpleMailMessage sms) {

        LOG.info("Simulando envio de email!");
        mailSender.send(sms);
        LOG.info("Email enviado com sucesso");
    }

    @Override
    public void sendHtmlEmail(MimeMessage sms) {
        LOG.info("Envio de email Html!");
        javaMailSender.send(sms);
        LOG.info("Email enviado com sucesso");
    }

//    @Override
//    public void sendOrderRecused(OrderRecusedDto order) {
//
//    }
}
