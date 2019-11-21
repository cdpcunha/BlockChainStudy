package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.entities.Product;
import com.blockchain.repository.ProductRepository;
import com.blockchain.services.exceptions.ObjectNotFound;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepo;

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Product findById(String id) {
		Optional<Product> product = productRepo.findById(id);
		return product.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
	}
}
