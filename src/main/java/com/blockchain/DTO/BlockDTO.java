package com.blockchain.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blockchain.entities.Block;
import com.blockchain.entities.Transaction;

@Document(collection = "block")
public class BlockDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	
	private String blockNumber;
	
	private Instant blockInitialDate;
	private Instant blockCloseDate;
	private String prevChain;
	private String nextChain;
	private List<Transaction> transactions = new ArrayList<>();
	private Integer hashCode;

	public BlockDTO(String blockNumber, Instant blockInitialDate, Instant blockCloseDate, String prevChain, String nextChain,
			List<Transaction> transactions, Integer hashCode) {
		super();
		this.blockNumber = blockNumber;
		this.blockInitialDate = blockInitialDate;
		this.blockCloseDate = blockCloseDate;
		this.prevChain = prevChain;
		this.nextChain = nextChain;
		this.transactions = transactions;
		this.hashCode = hashCode;
	}

	public BlockDTO() {
	}

	public Integer getHashCode() {
		return hashCode;
	}

	public void setHashCode(Integer hashCode) {
		this.hashCode = hashCode;
	}

	public BlockDTO(Block block) {
		super();
		this.blockNumber = block.getBlockNumber();
		this.blockInitialDate = block.getBlockInitialDate();
		this.blockCloseDate = block.getBlockCloseDate();
		this.prevChain = block.getPrevChain();
		this.nextChain = block.getNextChain();
		this.transactions = block.getTransactions();
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
		result = prime * result + ((blockNumber == null) ? 0 : blockNumber.hashCode());
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
		BlockDTO other = (BlockDTO) obj;
		if (blockNumber == null) {
			if (other.blockNumber != null)
				return false;
		} else if (!blockNumber.equals(other.blockNumber))
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
