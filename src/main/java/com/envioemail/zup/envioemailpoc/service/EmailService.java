package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import com.envioemail.zup.envioemailpoc.input.dto.OrderRecusedDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendOrderConfirmation(OrderData order);

    void sendOrderRecused(OrderRecusedDto order);

    void sendEmail(SimpleMailMessage sms);

    void sendOrderConfirmationHtmlEmail(OrderData order);

    void sendHtmlEmail(MimeMessage sms);

    void sendOrderRecusadedHtmlEmail(OrderRecusedDto orderData);

}
