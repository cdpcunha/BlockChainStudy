package com.blockchain.DTO;

import java.io.Serializable;
import java.time.Instant;

import com.blockchain.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private Instant birthdate;
	private String password;

	public UserDTO(User user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.birthdate = user.getBirthdate();
		this.password = user.getPassword();
	}

	public UserDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Instant getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Instant birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
