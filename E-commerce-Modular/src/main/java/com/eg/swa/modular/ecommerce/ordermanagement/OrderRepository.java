package com.eg.swa.modular.ecommerce.ordermanagement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.swa.modular.ecommerce.shared.Customer;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	 List<Order> findByCustomer(Customer customer);
}

