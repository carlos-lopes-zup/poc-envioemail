package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import com.envioemail.zup.envioemailpoc.input.dto.OrderRecusedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

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

    private SimpleMailMessage prepareSimpleMailMessageFromOrderRecusaded(OrderData order){

        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setTo(order.getEmailCliente());
        sm.setFrom(sender);
        sm.setSubject("Pedido Recusado! Código: "+order.getOrderNumber());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(order.toString());

        return sm;
    }

    protected String htmlFromTemplateOrderRecusaded(OrderRecusedDto orderData){

        Context context = new Context();
        context.setVariable("order", orderData);
        return templateEngine.process("email/pedidoRecusado",context);
    }

    protected String htmlFromTemplateOrder(OrderData orderData){

        Context context = new Context();
        context.setVariable("order", orderData);
        return templateEngine.process("email/confirmacaoPedido",context);
    }

    @Override
    public void sendOrderConfirmationHtmlEmail(OrderData order) {
        try {
            MimeMessage mm = prepareMimeMessageFromPedido(order);
            sendHtmlEmail(mm);
        }catch (MessagingException e){
            e.printStackTrace();
            System.out.println(e);
            sendOrderConfirmation(order);
        }
    }

    @Override
    public void sendOrderRecusadedHtmlEmail(OrderRecusedDto order) {
        try {
            MimeMessage mm = prepareMimeMessageFromOrdersRecusaded(order);
            sendHtmlEmail(mm);
        }catch (MessagingException e){
            e.printStackTrace();
            System.out.println(e);
            sendOrderRecused(order);
        }
    }

    protected MimeMessage prepareMimeMessageFromPedido(OrderData order) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true);

        mmh.setTo(order.getEmailCliente());
        mmh.setSubject("Pedido confirmado! Código: "+order.getOrderNumber());
        mmh.setFrom(sender);
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateOrder(order),true);

        return mimeMessage;
    }

    protected MimeMessage prepareMimeMessageFromOrdersRecusaded(OrderRecusedDto order) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true);

        mmh.setTo(order.getEmailCliente());
        mmh.setSubject("Pedido Recusado! Código: "+order.getOrderNumber());
        mmh.setFrom(sender);
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplateOrderRecusaded(order),true);

        return mimeMessage;
    }

    @Override
    public void sendOrderRecused(OrderRecusedDto order) {
        try {
            MimeMessage mm = prepareMimeMessageFromOrdersRecusaded(order);
            sendHtmlEmail(mm);
        }catch (MessagingException e){
            e.printStackTrace();
            System.out.println(e);
            sendOrderRecused(order);
        }
    }
}
