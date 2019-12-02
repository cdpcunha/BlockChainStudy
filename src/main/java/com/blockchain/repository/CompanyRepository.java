package com.blockchain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.entities.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

}