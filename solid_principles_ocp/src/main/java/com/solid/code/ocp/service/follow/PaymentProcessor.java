package com.solid.code.ocp.service.follow;

import java.util.List;

import com.solid.code.ocp.model.Payment;

public class PaymentProcessor {

    private final List<PaymentService> paymentServices;

    public PaymentProcessor(List<PaymentService> paymentServices) {
        this.paymentServices = paymentServices;
    }

    public void processPayment(Payment payment) {
    	
        for (PaymentService paymentService : paymentServices) {
            if (paymentService.supports(payment.getPaymentmethod())) {
                paymentService.processPayment(payment);
                return;
            }
        }
        throw new IllegalArgumentException("Invalid payment type");
    }
}
