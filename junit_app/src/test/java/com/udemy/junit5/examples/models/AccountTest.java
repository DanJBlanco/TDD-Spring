package com.udemy.junit5.examples.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @Test
    void testAccountName() {

        Account account = new Account("Daniel", new BigDecimal("10000.123123"));
//        account.setPerson("Daniel");

        String wanted = "Daniel";

        String real = account.getPerson();

        assertEquals(wanted, real);
        assertTrue(real.equals("Daniel"));
    }
}