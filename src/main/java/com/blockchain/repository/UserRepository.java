package com.blockchain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}