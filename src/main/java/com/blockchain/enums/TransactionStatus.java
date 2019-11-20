package com.blockchain.enums;

public enum TransactionStatus {
	STARTED(1),
	WAITING_TARGET_APPROVAL(2),
	PROCESSING(3),
	FINISHED(4),
	DENIED(5),
	CANCELED(6);
	
	
	private int code;
	
	private TransactionStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TransactionStatus valueOfStatus(int code) {
		for(TransactionStatus status : TransactionStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid transaction Status.");
	}
}
