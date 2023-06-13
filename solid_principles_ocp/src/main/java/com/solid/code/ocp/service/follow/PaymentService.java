package com.solid.code.ocp.service.follow;

import com.solid.code.ocp.model.Payment;

public interface PaymentService {

	boolean supports(String paymentType);

	void processPayment(Payment payment);

}
