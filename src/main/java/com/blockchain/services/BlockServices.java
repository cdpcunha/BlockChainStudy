package com.blockchain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.bcentities.Block;
import com.blockchain.repository.BlockRepository;

@Service
public class BlockServices {

	@Autowired
	private BlockRepository blockRepo;

	public List<Block> findAll() {
	return blockRepo.findAll();
	}
}
