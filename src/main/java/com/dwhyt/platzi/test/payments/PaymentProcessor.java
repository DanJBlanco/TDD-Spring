package com.dwhyt.platzi.test.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount ){

        PaymentResponse paymentResponse = this.paymentGateway.requestPayment(new PaymentRequest(amount));

        if( paymentResponse.getStatus() == PaymentResponse.PaymentStatus.OK){
            return  true;
        } else {
            return false;
        }
    }
}
