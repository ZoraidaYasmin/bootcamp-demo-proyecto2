package com.proyecto1.deposit.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto1.deposit.entity.Deposit;

@Repository
public interface DepositRepository extends ReactiveCrudRepository<Deposit, String> {
}
