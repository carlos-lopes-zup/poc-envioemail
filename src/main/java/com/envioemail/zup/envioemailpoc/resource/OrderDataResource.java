package com.envioemail.zup.envioemailpoc.resource;

import com.envioemail.zup.envioemailpoc.input.OrderData;
import com.envioemail.zup.envioemailpoc.input.ProductData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/ordersemails")
public class OrderDataResource {

    @PostMapping
    public ResponseEntity<String> sendOrdersEmails(@RequestBody OrderData orders){

        System.out.println("orders" +orders);
        return ResponseEntity.ok().body("Enviado");
    }

    @GetMapping
    public ResponseEntity<OrderData> getOrders(){
        ProductData prod = new ProductData("Ração", 2, 100.);
        ProductData prod1 = new ProductData("Pé de pato", 10, 150.);
        ProductData prod2 = new ProductData("Televisão", 3, 10002.);

        List<ProductData> products = new ArrayList<ProductData>();

        products.addAll(Arrays.asList(prod,prod1,prod2));

        OrderData orderData = new OrderData();
                orderData.setOrderNumber(17117156);
                orderData.setProds(products);
                
        return ResponseEntity.ok().body(orderData);
    }
}
