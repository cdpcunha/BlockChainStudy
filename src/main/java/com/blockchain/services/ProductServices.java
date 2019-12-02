package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.DTO.ProductDTO;
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

	public Product update(Product product) {
		Product newProduct = new Product();
		newProduct.setId(product.getId());
		updateData(newProduct, product);
		return productRepo.save(newProduct);
	}

	private void updateData(Product newProduct, Product product) {
		newProduct.setDescription(product.getDescription());
		newProduct.setProdName(product.getProdName());
	}
	
	public Product insert(Product product) {
		return productRepo.insert(product);
	}
	
	public Product fromDTO(ProductDTO dto) {
		return new Product(dto.getId(),dto.getProdName(),productRepo.findById(dto.getId()).get().getDescription());
	}
	
	public void deleteByID(String id) {
		findById(id); //valida a existência do Id
		productRepo.deleteById(id);
	}
}
