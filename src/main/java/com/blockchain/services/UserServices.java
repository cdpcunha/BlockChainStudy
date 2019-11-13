package com.blockchain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.entities.User;
import com.blockchain.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
	return userRepo.findAll();
	}
}
