package com.blockchain.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.DTO.TransactionDTO;
import com.blockchain.entities.Transaction;
import com.blockchain.services.TransactionServices;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResources {

	@Autowired
	private TransactionServices service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TransactionDTO>> findAll() {
		List<Transaction> listTransaction = service.findAll();
		List<TransactionDTO> listTransactionDTO = listTransaction.stream().map(x->new TransactionDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listTransactionDTO);
	}

	@RequestMapping(method = RequestMethod.GET , value = "/{id}")
	public ResponseEntity<TransactionDTO> findById(@PathVariable String id) {
		Transaction transaction = service.findById(id);
		return ResponseEntity.ok().body(new TransactionDTO(transaction));
	}
}
