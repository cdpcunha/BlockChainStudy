package com.blockchain.DTO;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.blockchain.entities.Company;

public class CompanyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String companyName;
	
	
	public CompanyDTO(Company company) {
		this.id = company.getId();
		this.companyName = company.getcompanyName();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
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
		CompanyDTO other = (CompanyDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", companyName=" + companyName + "]";
	}
	
	
}
