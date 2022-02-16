package com.envioemail.zup.envioemailpoc.input;


import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class OrderDataTest {

    OrderData order;
    ProductData productData;
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeEach
    void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

        List<ProductData> products = new ArrayList<ProductData>();

        productData = ProductData
                .builder()
                .name("Geladeira")
                .quantity(2)
                .unitPrice(2.5)
                .build();

        products.add(productData);

        order = OrderData
                .builder()
                .orderNumber(123456)
                .nomeCliente("Carlos")
                .prods(products)
                .build();
    }

    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        assertTrue(!order.getTotalOrder().isNaN());
        assertEquals(productData.getSubTotal(), productData.getUnitPrice() * productData.getQuantity());
    }

    @Test
    public void shouldHaveNoViolations() {

        //when:
        Set<ConstraintViolation<OrderData>> violations
                = validator.validate(order);
        //then:
        assertTrue(violations.isEmpty());
    }

    @Test
    public void shouldDetectInvalidName() {
        //given too short name:

        order.setNomeCliente("");

        //when:
        Set<ConstraintViolation<OrderData>> violations
                = validator.validate(order);

        //then:
        assertEquals(violations.size(), 2);

        ConstraintViolation<OrderData> violation
                = violations.iterator().next();

        assertEquals("Preenchimento de nome é obrigatório",
                violation.getMessage());
        assertEquals("nomeCliente", violation.getPropertyPath().toString());
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }
}
