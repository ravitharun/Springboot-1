package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BankRepo;
import com.example.demo.model.BankModel;
import com.example.demo.response.bankAccountDto;

import jakarta.transaction.Transactional;

@Service
public class BankServices {
@Autowired
private BankRepo bnkRepo;



public bankAccountDto  AccountCreation(bankAccountDto bank) {
try {
    BankModel account = new BankModel();

    account.setAccount_number(bank.getAccount_number());
    account.setAccountHoldername(bank.getAccountHoldername());
    account.setBackName(bank.getBackName());
    account.setBalance(bank.getBalance());

    bnkRepo.save(account);

    return bank;
} catch (Exception e) {
	System.err.println(e.getMessage());
}
return bank;
}



@Transactional
public String TransferMoney(long user_id_from,long user_id_to,double transferMoney) {
	BankModel sender = bnkRepo.findById(user_id_from)
	        .orElseThrow();

	BankModel receiver = bnkRepo.findById(user_id_to)
	        .orElseThrow();
	if(transferMoney>=100000) {
		
		return "U cant transfer the Money above 1 lakh"; 
	}
	if(transferMoney<=0) {
		
		
		return "money can transfer >=1";
	}
	if (sender.getBalance() < transferMoney) {
	    return "Insufficient balance";
	}
	sender.setBalance(sender.getBalance()-transferMoney);
	receiver.setBalance(receiver.getBalance() + transferMoney);
	bnkRepo.save(sender);
	bnkRepo.save(receiver);
	 return "Money transferred successfully";
}
}



