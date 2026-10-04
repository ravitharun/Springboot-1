package com.example.demo.model;

import jakarta.persistence.Column;
//import org.hibernate.validator.constraints.UniqueElements;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bankAccounts")
public class BankModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long user_id;
	@Column(unique = true)
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
