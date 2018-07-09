package com.uvk.model;

public class Vendor {
	
	private String BankAccountNumber;
	private String NextCheckNumber;
	//private String tableName;
	public String getBankAccountNumber() {
		return BankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		BankAccountNumber = bankAccountNumber;
	}
	public String getNextCheckNumber() {
		return NextCheckNumber;
	}
	public void setNextCheckNumber(String nextCheckNumber) {
		NextCheckNumber = nextCheckNumber;
	}
	@Override
	public String toString() {
		return "Vendor [BankAccountNumber=" + BankAccountNumber + ", NextCheckNumber=" + NextCheckNumber + "]";
	}
	
	
	
	
	
	
}
