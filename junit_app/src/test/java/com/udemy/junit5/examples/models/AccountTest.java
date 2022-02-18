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


    @Test
    void testAccountBalance() {

        Account account = new Account("Daniel", new BigDecimal("3333.123123"));

        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
        assertEquals(3333.123123, account.getBalance().doubleValue());



    }
}