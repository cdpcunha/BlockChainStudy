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
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user){
		User obj = service.findById(id);
		obj.setId(id);
		obj = service.update(user);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
		User obj = service.fromDTO(objDTO);
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
