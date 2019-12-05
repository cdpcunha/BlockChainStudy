package com.blockchain.services.exceptions;

public class HashAlreadyCalculated extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public HashAlreadyCalculated (String msg) {
		super(msg);
	}
}
