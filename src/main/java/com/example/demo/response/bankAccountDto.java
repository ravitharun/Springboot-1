package com.example.demo.response;


public class bankAccountDto {

	
	
	private long user_id;
	private int Account_number;
	private double balance;
	private String BackName;
	private String AccountHoldername;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(int account_number) {
		Account_number = account_number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBackName() {
		return BackName;
	}
	public void setBackName(String backName) {
		BackName = backName;
	}
	public String getAccountHoldername() {
		return AccountHoldername;
	}
	public void setAccountHoldername(String accountHoldername) {
		AccountHoldername = accountHoldername;
	}
	
	
}
