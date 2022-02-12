package com.envioemail.zup.envioemailpoc.input;


import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class OrderDataTest {

    OrderData order;

    @BeforeEach
    void init() {

//         order = OrderData
//                .builder()
//                .id(1)
//                .prods("Sapato")
//                .precoUnitario(100.)
//                .quantidade(10)
//                .subTotal(100.)
//                .build();
//
//        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
    //    assertTrue(!order.toString().isEmpty());
    }
}
