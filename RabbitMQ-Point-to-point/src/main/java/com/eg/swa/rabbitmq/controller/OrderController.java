package com.eg.swa.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.swa.rabbitmq.model.Order;
import com.eg.swa.rabbitmq.publish.OrderPublisher;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderPublisher orderPublisher;

	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody Order order){
		orderPublisher.publish(order);
		return new ResponseEntity<>("Order Created", HttpStatus.CREATED);
	}

}
