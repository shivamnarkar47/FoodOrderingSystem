package com.foodOrdering.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.foodOrdering.backend.models.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
