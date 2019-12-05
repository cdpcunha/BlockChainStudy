package com.blockchain.services.exceptions;

public class CloseDateExists extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CloseDateExists (String msg) {
		super(msg);
	}
}
