package com.dwhyt.platzi.test.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup(){
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct(){

        /***
         * Los Test se dividen normalmente en 3 partes
         * 1- preparacion de los objetos
         * 2- Llamada al metodo
         * 3- Comprobacion del resultado
         */

        // 1ra parte
        // PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        // PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        // 2da Parte
        boolean result = paymentProcessor.makePayment(1000);

        // 3ra Parte
        assertTrue(result);

        /***
         * No siempre es legible, ya que se pueden hacer in-line del codigo
         * - normalmente al tener lineas repetidas se crea una funcion SETUP
         */
    }

    @Test
    public void payment_is_wrong(){

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        assertFalse(paymentProcessor.makePayment(1000));
    }

}