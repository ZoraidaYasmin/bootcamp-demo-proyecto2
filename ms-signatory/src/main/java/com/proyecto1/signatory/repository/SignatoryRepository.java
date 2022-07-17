package com.proyecto1.signatory.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto1.signatory.entity.Signatory;

@Repository
public interface SignatoryRepository extends ReactiveCrudRepository<Signatory, String> {
}
