package com.blockchain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.entities.Transaction;

@Repository()
public interface TransactionRepository extends MongoRepository<Transaction, String>{

}
