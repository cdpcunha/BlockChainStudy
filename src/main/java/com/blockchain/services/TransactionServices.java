package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.DTO.TransactionDTO;
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
	
	public Transaction update(Transaction transaction) {
		Transaction newTransaction = new Transaction();
		newTransaction.setId(transaction.getId());
		updateData(newTransaction, transaction);
		return transactionRepo.save(newTransaction);
	}

	private void updateData(Transaction newTransaction, Transaction transaction) {
		newTransaction.setOriginCompany(transaction.getOriginCompany());
		newTransaction.setOriginItemList(transaction.getOriginItemList());
		newTransaction.setOriginUser(transaction.getOriginUser());
		newTransaction.setTargetCompany(transaction.getTargetCompany());
		newTransaction.setTargetItemList(transaction.getTargetItemList());
		newTransaction.setTargetUser(transaction.getTargetUser());
		newTransaction.setTransactionStatus(transaction.getTransactionStatus());
	}
	
	public Transaction insert(Transaction transaction) {
		return transactionRepo.insert(transaction);
	}
	
	public Transaction fromDTO(TransactionDTO dto) {
		return new Transaction(dto.getId(),dto.getOriginCompany(),dto.getOriginUser(), dto.getTargetCompany(),dto.getTargetUser(),
				dto.getTransactionStatus(), dto.getOriginItemList(), dto.getTargetItemList());
	}
	
	public void deleteByID(String id) {
		findById(id); //valida a existência do Id
		transactionRepo.deleteById(id);
	}
}
