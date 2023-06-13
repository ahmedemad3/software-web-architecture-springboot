package com.solid.code.ocp.service.not.follow;

import com.solid.code.ocp.model.Payment;

public class PaymentProcessor {

	public void processPayment(Payment payment) {
		
		if (payment.getPaymentmethod().equalsIgnoreCase("creditCard")) {
			// Process credit card payment
			CreditCardPaymentService creditCardPaymentService = new CreditCardPaymentService();
			creditCardPaymentService.processCreditCardPayment(payment);
		} else if (payment.getPaymentmethod().equalsIgnoreCase("paypal")) {
			// Process PayPal payment
			PayPalPaymentService palPaymentService = new PayPalPaymentService();
			palPaymentService.processPayPalPayment(payment);
		} else if (payment.getPaymentmethod().equalsIgnoreCase("bitcoin")) {
			BitcoinPaymentService bitcoinPaymentService = new BitcoinPaymentService();
			bitcoinPaymentService.processBitcoinPayment(payment);
		} 
		else {
			throw new IllegalArgumentException("Invalid payment method");
		}
	}
}
