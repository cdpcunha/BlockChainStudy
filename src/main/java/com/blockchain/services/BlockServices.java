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
	
	public Block update(Block block) {
		Optional<Block> newBlock = blockRepo.findById(block.getBlockNumber());
		updateData(newBlock,block);
		return blockRepo.save(newBlock.get());
	}

	private void updateData(Optional<Block> newBlock, Block block) {
		newBlock.get().setBlockCloseDate(block.getBlockCloseDate());
		newBlock.get().setBlockInitialDate(block.getBlockInitialDate());
		newBlock.get().setPrevChain(block.getPrevChain());
		newBlock.get().setNextChain(block.getNextChain());
		newBlock.get().setTransactions(block.getTransactions());
	}
}
