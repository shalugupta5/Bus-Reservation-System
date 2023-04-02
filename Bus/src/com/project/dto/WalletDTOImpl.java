package com.project.dto;

public class WalletDTOImpl implements WalletDTO{
	private int userID;
	private double balance;
	
	public WalletDTOImpl() {
		
	}
	
	
	public WalletDTOImpl(int userID, double balance) {
		super();
		this.userID = userID;
		this.balance = balance;
	}

	@Override
	public int getUserID() {
		return userID;
	}

	@Override
	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "WalletDTOImpl [userID=" + userID + ", balance=" + balance + "]";
	}


	
	
	

}
