package com.eg.swa.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.swa.rest.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
