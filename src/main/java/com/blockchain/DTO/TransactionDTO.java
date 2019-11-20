package com.blockchain.DTO;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blockchain.entities.Company;
import com.blockchain.entities.Product;
import com.blockchain.entities.Transaction;
import com.blockchain.entities.User;

@Document(collection = "transaction")
public class TransactionDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Company originCompany;
	private User originUser;
	private Company targetCompany;
	private User targetUser;
	private Integer TransactionStatus;
	private List<Product> originProductList;
	private List<Product> targetProductList;

	public TransactionDTO(Transaction transaction) {
		super();
		this.id = transaction.getId();
		this.originCompany = transaction.getOriginCompany();
		this.originUser = transaction.getOriginUser();
		this.targetCompany = transaction.getTargetCompany();
		this.targetUser = transaction.getTargetUser();
		TransactionStatus = transaction.getTransactionStatus();
		this.originProductList = transaction.getOriginProductList();
		this.targetProductList = transaction.getTargetProductList();
	}

	public Company getOriginCompany() {
		return originCompany;
	}

	public void setOriginCompany(Company originCompany) {
		this.originCompany = originCompany;
	}

	public User getOriginUser() {
		return originUser;
	}

	public void setOriginUser(User originUser) {
		this.originUser = originUser;
	}

	public Company getTargetCompany() {
		return targetCompany;
	}

	public void setTargetCompany(Company targetCompany) {
		this.targetCompany = targetCompany;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	public Integer getTransactionStatus() {
		return TransactionStatus;
	}

	public void setTransactionStatus(Integer transactionStatus) {
		TransactionStatus = transactionStatus;
	}

	public List<Product> getOriginProductList() {
		return originProductList;
	}

	public void setOriginProductList(List<Product> originProductList) {
		this.originProductList = originProductList;
	}

	public List<Product> getTargetProductList() {
		return targetProductList;
	}

	public void setTargetProductList(List<Product> targetProductList) {
		this.targetProductList = targetProductList;
	}

	public String getId() {
		return id;
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
		TransactionDTO other = (TransactionDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", originCompany=" + originCompany + ", originUser=" + originUser
				+ ", targetCompany=" + targetCompany + ", targetUser=" + targetUser + ", TransactionStatus="
				+ TransactionStatus + ", originProductList=" + originProductList + ", targetProductList="
				+ targetProductList + "]";
	}

	
}