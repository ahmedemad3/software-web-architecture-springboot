package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public class BitcoinPaymentService implements PaymentService {

	@Override
	public boolean supports(String paymentType) {
		return paymentType.equalsIgnoreCase("bitcoin");
	}

	@Override
	public void processPayment(Payment payment) {
		// TODO Auto-generated method stub

	}

}
