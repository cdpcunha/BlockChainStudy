package com.blockchain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "block")
public class Block implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	private String blockNumber;
	
	private Instant blockInitialDate;
	private Instant blockCloseDate;
	private String prevChain;
	private String nextChain;
	private List<Transaction> transactions = new ArrayList<>();

	public Block(String blockNumber, Instant blockInitialDate, Instant blockCloseDate, String prevChain, String nextChain,
			List<Transaction> transactions) {
		super();
		this.blockNumber = blockNumber;
		this.blockInitialDate = blockInitialDate;
		this.blockCloseDate = blockCloseDate;
		this.prevChain = prevChain;
		this.nextChain = nextChain;
		this.transactions = transactions;
	}

	public Block() {
	}

	public String getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}

	public Instant getBlockInitialDate() {
		return blockInitialDate;
	}

	public void setBlockInitialDate(Instant blockInitialDate) {
		this.blockInitialDate = blockInitialDate;
	}

	public Instant getBlockCloseDate() {
		return blockCloseDate;
	}

	public void setBlockCloseDate(Instant blockCloseDate) {
		this.blockCloseDate = blockCloseDate;
	}

	public String getPrevChain() {
		return prevChain;
	}

	public void setPrevChain(String prevChain) {
		this.prevChain = prevChain;
	}

	public String getNextChain() {
		return nextChain;
	}

	public void setNextChain(String nextChain) {
		this.nextChain = nextChain;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockCloseDate == null) ? 0 : blockCloseDate.hashCode());
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
		Block other = (Block) obj;
		if (blockCloseDate == null) {
			if (other.blockCloseDate != null)
				return false;
		} else if (!blockCloseDate.equals(other.blockCloseDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Block [blockNumber=" + blockNumber + ", blockInitialDate=" + blockInitialDate + ", blockCloseDate="
				+ blockCloseDate + ", prevChain=" + prevChain + ", nextChain=" + nextChain + ", transactions="
				+ transactions + "]";
	}
	
	
	
}
