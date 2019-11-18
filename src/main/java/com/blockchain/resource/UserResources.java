package com.blockchain.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.DTO.UserDTO;
import com.blockchain.entities.User;
import com.blockchain.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserServices service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> listUser = service.findAll();
		List<UserDTO> listUserDTO = listUser.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listUserDTO);
	}

	@RequestMapping(method = RequestMethod.GET , value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
}
