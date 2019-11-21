package com.blockchain.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.DTO.BlockDTO;
import com.blockchain.entities.Block;
import com.blockchain.services.BlockServices;

@RestController
@RequestMapping(value = "/blocks")
public class BlockResources {

	@Autowired
	private BlockServices service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BlockDTO>> findAll() {
		List<Block> listBlock = service.findAll();
		List<BlockDTO> listBlockDTO = listBlock.stream().map(x->new BlockDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listBlockDTO);
	}

	@RequestMapping(method = RequestMethod.GET , value = "/{id}")
	public ResponseEntity<BlockDTO> findById(@PathVariable String id) {
		Block block = service.findById(id);
		return ResponseEntity.ok().body(new BlockDTO(block));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Block> update(@PathVariable String id, @RequestBody Block block){
		Block obj = service.findById(id);
		obj.setBlockNumber(id);
		obj = service.update(block);
		return ResponseEntity.noContent().build();
	}
	
}
