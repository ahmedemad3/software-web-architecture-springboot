package com.eg.swa.ntier.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.swa.ntier.shopping.model.Customer;
import com.eg.swa.ntier.shopping.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	 List<Order> findByCustomer(Customer customer);
}

