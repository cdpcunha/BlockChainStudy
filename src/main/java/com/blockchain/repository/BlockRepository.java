package com.blockchain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.entities.Block;

@Repository()
public interface BlockRepository extends MongoRepository<Block, String>{

}
