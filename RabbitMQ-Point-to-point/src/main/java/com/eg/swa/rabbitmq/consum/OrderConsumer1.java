package com.eg.swa.rabbitmq.consum;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eg.swa.rabbitmq.model.Order;
import com.eg.swa.rabbitmq.service.OrderService;

@Component
public class OrderConsumer1 {

	@Autowired
	private OrderService orderService;

	@RabbitListener(queues = "order.Queue")
	public void consumeOrder(Order order) {
		System.out.println("Consume Order : " + order.getCustomerName());
		orderService.processOrder(order);
	}
}
