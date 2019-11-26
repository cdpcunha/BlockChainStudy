package com.blockchain.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Transaction> update(@PathVariable String id, @RequestBody Transaction transaction){
		Transaction obj = service.findById(id);
		obj.setId(id);
		obj = service.update(transaction);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody TransactionDTO objDTO){
		Transaction obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody String id){
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}
}
