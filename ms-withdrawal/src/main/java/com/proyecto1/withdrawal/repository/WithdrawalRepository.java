package com.proyecto1.withdrawal.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto1.withdrawal.entity.Withdrawal;

@Repository
public interface WithdrawalRepository extends ReactiveCrudRepository<Withdrawal, String> {
}
