package com.envioemail.zup.envioemailpoc.service;

import com.envioemail.zup.envioemailpoc.dao.OrderDataDao;
import com.envioemail.zup.envioemailpoc.input.OrderData;
import com.envioemail.zup.envioemailpoc.input.dto.OrderRecusedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDataService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private OrderDataDao orderDataDao;

    public void sendMailOrderRecusaded(OrderRecusedDto orderRecusedDto){

        emailService.sendOrderRecusadedHtmlEmail(orderRecusedDto);

    }

    public void sendMailOrderConfirmation(OrderData order){

            orderDataDao.saveOrders(order);

            System.out.println("Busca Redis:" + orderDataDao.getAllEmployees() );

            emailService.sendOrderConfirmationHtmlEmail(order);
    }
}
