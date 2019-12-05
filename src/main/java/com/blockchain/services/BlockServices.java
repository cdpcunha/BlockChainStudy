package com.blockchain.services;

import java.time.Instant;
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

	public void closeBlock(String blockID) {
		Block closingBlock = blockRepo.findById(blockID).get();
		if(closingBlock.getBlockCloseDate() == null || closingBlock.getHashCode()== null || closingBlock.getNextChain() == null) {
			Block recentCreatedNewBlock = new Block(null,Instant.now(),null,closingBlock.getBlockNumber(),null,null);
			blockRepo.save(recentCreatedNewBlock);
			closingBlock.setNextChain(recentCreatedNewBlock.getBlockNumber());
			closingBlock.setBlockCloseDate(Instant.now());
			closingBlock.setHashCode();			
			update(closingBlock);
		}
	}
	
	public List<Block> findAll() {
	return blockRepo.findAll();
	}
	
	public Block findById(String id) {
		Optional<Block> block = blockRepo.findById(id);
		return block.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
	}
	
	public Block update(Block block) {
		Block newBlock = new Block();
		newBlock.setBlockNumber(block.getBlockNumber());
		updateData(newBlock,block);
		return blockRepo.save(newBlock);
	}

	private void updateData(Block newBlock, Block block) {
		newBlock.setBlockCloseDate(block.getBlockCloseDate());
		newBlock.setBlockInitialDate(block.getBlockInitialDate());
		newBlock.setPrevChain(block.getPrevChain());
		newBlock.setNextChain(block.getNextChain());
		newBlock.setTransactions(block.getTransactions());
		newBlock.setHashCode();
	}
}
