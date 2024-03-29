package com.blockchain.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "company")
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String companyName;


	public Company(String id, String companyName) {
		super();
		this.id = id;
		this.companyName = companyName;
	}
	
	public Company() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
	}

	public String getcompanyName() {
		return companyName;
	}

	public void setcompanyName(String companyName) {
		this.companyName = companyName;
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
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "company [id=" + id + ", companyName=" + companyName + "]";
	}
	
	
	
	
}
