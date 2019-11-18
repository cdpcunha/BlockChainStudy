package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.entities.Block;
import com.blockchain.repository.BlockRepository;
import com.blockchain.services.exceptions.ObjectNotFound;

@Service
public class BlockServices {

	@Autowired
	private BlockRepository blockRepo;

	public List<Block> findAll() {
	return blockRepo.findAll();
	}
	
	public Block findById(String id) {
		Optional<Block> block = blockRepo.findById(id);
		return block.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
	}
}
