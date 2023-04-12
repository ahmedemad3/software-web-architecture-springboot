package com.eg.swa.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.swa.rest.model.PaymentRequest;
import com.eg.swa.rest.model.PaymentResponse;
import com.eg.swa.rest.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest paymentRequest) {
		PaymentResponse paymentResponse = paymentService.processPayment(paymentRequest);
		return ResponseEntity.ok(paymentResponse);
	}
}
