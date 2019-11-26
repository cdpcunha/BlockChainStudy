package com.blockchain.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.blockchain.repository.BlockRepository;
import com.blockchain.repository.ProductRepository;
import com.blockchain.repository.UserRepository;

@Configuration
public class Configurations implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BlockRepository blockRepo;

	@Autowired
	ProductRepository prodRepo;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 * 
		 * 
		 * Instanciação dos blocos, Genesis e o Primeiro destes blockRepo.deleteAll();
		 * Block genesisBlock = new Block(null, Instant.now(), Instant.now(), null,
		 * null, null); blockRepo.save(genesisBlock); Block block1 = new Block(null,
		 * Instant.now(), null, genesisBlock.getBlockNumber(), null, null);
		 * blockRepo.save(block1); genesisBlock.setNextChain(block1.getBlockNumber());
		 * blockRepo.save(genesisBlock);
		 * 
		 * 
		 * Product prod1 = new Product(null,"Real Currency",
		 * "Brazillian Currency, Real"); Product prod2 = new
		 * Product(null,"Dollar Currency", "United States Currency, Dollar"); Product
		 * prod3 = new Product(null,"Generic Product",
		 * "Representation of a Generic Product (Unit)");
		 * prodRepo.saveAll(Arrays.asList(prod1,prod2,prod3));
		 * 
		 *
		 * 
		 * userRepo.deleteAll(); User u1 = new User(null, "João Paulo Peixoto",
		 * sdf.parse("08/05/1991"), "123456"); User u2 = new User(null,
		 * "Julyana Azevedo Ribeiro", sdf.parse("01/03/1991"), "010391"); User u3 = new
		 * User(null, "Juca Doidão", sdf.parse("28/01/1993"), "doidaomemo");
		 * userRepo.saveAll(Arrays.asList(u1,u2,u3));
		 */
	}

}
