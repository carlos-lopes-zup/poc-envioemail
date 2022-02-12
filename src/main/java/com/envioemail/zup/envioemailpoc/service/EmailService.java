package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

public interface EmailService {

    void sendOrderConfirmation(OrderData order);

    void sendEmail(SimpleMailMessage sms);

}
