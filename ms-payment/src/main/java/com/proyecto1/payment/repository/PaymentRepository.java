package com.proyecto1.payment.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto1.payment.entity.Payment;

@Repository
public interface PaymentRepository extends ReactiveCrudRepository<Payment, String> {
}
