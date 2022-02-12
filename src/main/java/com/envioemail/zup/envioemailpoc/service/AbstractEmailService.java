package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmation(OrderData order) {

        SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(order);
        sendEmail(sm);
    }

    private SimpleMailMessage prepareSimpleMailMessageFromPedido(OrderData order){

        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setTo(order.getEmailCliente());
        sm.setFrom(sender);
        sm.setSubject("Pedido Confirmado! Código: "+order.getOrderNumber());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(order.toString());

        return sm;
    }
}
