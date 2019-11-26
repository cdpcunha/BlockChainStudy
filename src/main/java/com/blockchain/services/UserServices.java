package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.DTO.UserDTO;
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

	public User update(User user) {
		User newUser = new User();
		newUser.setId(user.getId());
		updateData(newUser, user);
		return userRepo.save(newUser);
	}

	private void updateData(User newUser, User user) {
		newUser.setBirthdate(user.getBirthdate());
		newUser.setPassword(user.getPassword());
		newUser.setUserName(user.getUserName());
	}
	
	public User insert(User user) {
		return userRepo.insert(user);
	}
	
	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(),dto.getUserName(),dto.getBirthdate(),dto.getPassword());
	}
	
	public void deleteByID(String id) {
		findById(id); //valida a existência do Id
		userRepo.deleteById(id);
	}
}
