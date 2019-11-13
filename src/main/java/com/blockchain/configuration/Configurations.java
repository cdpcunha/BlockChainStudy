package com.blockchain.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.blockchain.repository.BlockRepository;
import com.blockchain.repository.UserRepository;

@Configuration
public class Configurations implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BlockRepository blockRepo;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Criação do Bloco Genesis Block genesisBlock = new Block(null, null,
		 * Instant.now(), null, null, null); blockRepo.save(genesisBlock);
		 */

	}

}
