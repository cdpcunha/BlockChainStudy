package com.blockchain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.entities.Product;
import com.blockchain.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

	@Autowired
	private ProductServices service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> listProduct = service.findAll();
		return ResponseEntity.ok().body(listProduct);
	}

	@RequestMapping(method = RequestMethod.GET , value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable String id) {
		Product product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
}
