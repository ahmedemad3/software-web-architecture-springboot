package com.eg.swa.WS.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eg.swa.WS.model.PaymentRequest;
import com.eg.swa.WS.model.PaymentResponse;
import com.eg.swa.WS.service.PaymentService;

@Endpoint
public class PaymentEndpoint {

	private PaymentService paymentService;
	
	@Autowired
    public PaymentEndpoint(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

	@PayloadRoot(namespace = "http://example.com/payment", localPart = "PaymentRequest")
	@ResponsePayload
	public PaymentResponse processPayment(@RequestPayload PaymentRequest request) {
		return paymentService.processPayment(request);
	}

}