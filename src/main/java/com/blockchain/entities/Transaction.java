package com.blockchain.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Company originCompany;
	private User originUser;
	private Company targetCompany;
	private User targetUser;
	private Integer TransactionStatus;
	private List<Item> originItemList;
	private List<Item> targetItemList;

	public Transaction(String id, Company originCompany, User originUser, Company targetCompany, User targetUser,
			Integer transactionStatus, List<Item> originItemList, List<Item> targetItemList) {
		super();
		this.id = id;
		this.originCompany = originCompany;
		this.originUser = originUser;
		this.targetCompany = targetCompany;
		this.targetUser = targetUser;
		TransactionStatus = transactionStatus;
		this.originItemList = originItemList;
		this.targetItemList = targetItemList;
	}

	public Transaction() {

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

	public void setId(String id) {
		this.id = id;
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

	public List<Item> getOriginItemList() {
		return originItemList;
	}

	public void setOriginItemList(List<Item> originItemList) {
		this.originItemList = originItemList;
	}

	public List<Item> getTargetItemList() {
		return targetItemList;
	}

	public void setTargetItemList(List<Item> targetItemList) {
		this.targetItemList = targetItemList;
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
		Transaction other = (Transaction) obj;
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
				+ TransactionStatus + ", originItemList=" + originItemList + ", targetItemList="
				+ targetItemList + "]";
	}

	
}
