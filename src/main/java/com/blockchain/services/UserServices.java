package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.entities.User;
import com.blockchain.repository.UserRepository;
import com.blockchain.services.exceptions.ObjectNotFound;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
	}
}
