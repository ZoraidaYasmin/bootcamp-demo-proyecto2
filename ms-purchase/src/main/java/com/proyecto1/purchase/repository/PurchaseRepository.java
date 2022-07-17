package com.proyecto1.purchase.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto1.purchase.entity.Purchase;

@Repository
public interface PurchaseRepository extends ReactiveCrudRepository<Purchase, String> {
}
