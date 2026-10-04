package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.bankAccountDto;
import com.example.demo.service.BankServices;

@RestController
@RequestMapping("/api/bank/Account")
public class BanktransactionController {

	@Autowired
	BankServices bnkserv;
//	get the account Info
	@GetMapping("/bankInfo")
	
	
	public String GetAccountInfo() {
		
		
		return "extends";
	}
	
//	make a new account
	
	@PostMapping("/Creation")
	
	
	
	public bankAccountDto AddAccount(@RequestBody bankAccountDto bank) {

		return bnkserv.AccountCreation(bank);
	}
	
	
	
//	transfer the Money
	
		
	@PutMapping("/transAction/{user_id_from}/{user_id_to}/{transferMoney}")
	public String transaction(
	        @PathVariable("user_id_from") long user_id_from,
	        @PathVariable("user_id_to") long user_id_to,
	        @PathVariable("transferMoney") double transferMoney) {


	    return bnkserv.TransferMoney(user_id_from,user_id_to,transferMoney);
	}
	
	
	
	
	
	
}
