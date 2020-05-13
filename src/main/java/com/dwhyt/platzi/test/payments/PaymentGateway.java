package com.dwhyt.platzi.test.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
