package com.eg.swa.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.swa.rabbitmq.model.Order;
import com.eg.swa.rabbitmq.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void processOrder(Order order) {
        // Save the order to the database
        orderRepository.save(order);
    }
}

