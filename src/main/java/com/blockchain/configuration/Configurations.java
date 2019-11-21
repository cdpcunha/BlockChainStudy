package com.blockchain.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.blockchain.entities.Product;
import com.blockchain.repository.BlockRepository;
import com.blockchain.repository.ProductRepository;
import com.blockchain.repository.UserRepository;

@Configuration
@Profile("test")
public class Configurations implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BlockRepository blockRepo;

	@Autowired
	ProductRepository prodRepo;
	
	@Override
	public void run(String... args) throws Exception {

		Product prod1 = new Product(null,"Real Currency", "Brazillian Currency, Real");
		Product prod2 = new Product(null,"Dollar Currency", "United States Currency, Dollar");
		Product prod3 = new Product(null,"Generic Product", "Representation of a Generic Product (Unit)");
		prodRepo.saveAll(Arrays.asList(prod1,prod2,prod3));
	}

}
