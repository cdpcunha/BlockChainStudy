package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.entities.Transaction;
import com.blockchain.repository.TransactionRepository;
import com.blockchain.services.exceptions.ObjectNotFound;

@Service
public class TransactionServices {

	@Autowired
	private TransactionRepository transactionRepo;

	public List<Transaction> findAll() {
	return transactionRepo.findAll();
	}
	
	public Transaction findById(String id) {
		Optional<Transaction> transaction = transactionRepo.findById(id);
		return transaction.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
	}
}
