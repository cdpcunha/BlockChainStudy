package com.blockchain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}