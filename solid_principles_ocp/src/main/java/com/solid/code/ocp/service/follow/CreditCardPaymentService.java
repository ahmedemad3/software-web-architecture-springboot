package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public class CreditCardPaymentService implements PaymentService {

	@Override
	public boolean supports(String paymentType) {
		  return paymentType.equalsIgnoreCase("creditCard");
	}

	@Override
	public void processPayment(Payment payment) {
		// business Logic
	}

}
