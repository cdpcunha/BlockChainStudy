package com.blockchain.bcentities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Block {
	private Long blockNumber;
	private Instant blockInitialDate;
	private Instant blockCloseDate;
	private String prevChain;
	private String nextChain;
	private List<Transaction> transactions = new ArrayList<>();
	
	
}
