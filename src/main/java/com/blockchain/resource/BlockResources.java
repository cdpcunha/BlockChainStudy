package com.blockchain.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.bcentities.Block;
import com.blockchain.services.BlockServices;

@RestController
@RequestMapping(value = "/blocks")
public class BlockResources {

	@Autowired
	private BlockServices service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Block>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	public Block findById(Integer id) {
		return null;
	}
}
