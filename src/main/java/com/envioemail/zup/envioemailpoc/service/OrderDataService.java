package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDataService {

    @Autowired
    private EmailService emailService;

    public void sendMailOrderConfirmation(OrderData order){
            emailService.sendOrderConfirmation(order);
    }
}
