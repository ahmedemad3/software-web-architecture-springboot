package com.eg.swa.rabbitmq.publish;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eg.swa.rabbitmq.model.Order;

@Service
public class OrderPublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingKey;
	
	public void publish(Order order) {
		System.out.println("Publish Order");
		rabbitTemplate.convertAndSend(exchange ,routingKey , order);
	}

}
