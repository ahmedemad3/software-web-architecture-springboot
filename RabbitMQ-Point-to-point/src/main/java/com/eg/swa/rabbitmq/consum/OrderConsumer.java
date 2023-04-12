package com.eg.swa.rabbitmq.consum;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eg.swa.rabbitmq.model.Order;
import com.eg.swa.rabbitmq.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderConsumer implements MessageListener {

	private OrderService orderService;

	@Autowired
	public OrderConsumer(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public void onMessage(Message message) {
		System.out.println("receive order");
		String body = new String(message.getBody());
		System.out.println(body);
		ObjectMapper mapper = new ObjectMapper();
		Order order = null;
		try {
			order = mapper.readValue(body, Order.class);
			System.out.println("Order : " + order.getCustomerName());
			orderService.processOrder(order);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
