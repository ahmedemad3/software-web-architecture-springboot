package com.eg.swa.rabbitmq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.swa.rabbitmq.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
