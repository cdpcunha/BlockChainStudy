package com.blockchain.DTO;

import java.io.Serializable;
import java.time.Instant;

import com.blockchain.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private Instant birthdate;

	public UserDTO(User user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.birthdate = user.getBirthdate();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", birthdate=" + birthdate + "]";
	}
	
	
}
