package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.bankAccountDto;
import com.example.demo.service.BankServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(
	    name = "Bank Accounts",
	    description = "APIs for managing bank accounts"
	)
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
	
	
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
		    content = @Content(
		        examples = @ExampleObject(
		            name = "Bank Account Example",
		            value = """
		            {
		                "account_number": 103,
		                "accountHoldername": "Tharun",
		                "balance": 5000
		            }
		            """
		        )
		    )
		)
	public ResponseEntity<?> AddAccount(@RequestBody 
			
			
			bankAccountDto bank) {
System.err.println(bank.getAccount_number()+"accAccount_number");
		return bnkserv.AccountCreation(bank);
	}
	
//	transfer the Money
	
	@Operation(
			summary = "Get user by ID",
			description = "Fetches a single user using the user ID"
			)
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200",
	        description = "Money transferred successfully"
	    ),
	    @ApiResponse(
	        responseCode = "400",
	        description = "Invalid transfer amount"
	    ),
	    @ApiResponse(
	        responseCode = "404",
	        description = "Account not found"
	    )
	})
		
	@PutMapping("/transAction/{user_id_from}/{user_id_to}/{transferMoney}")
	public String transaction(
		    @Parameter(description = "ID of the account sending money")
		    @PathVariable("user_id_from") long user_id_from,

		    @Parameter(description = "ID of the account receiving money")
		    @PathVariable("user_id_to") long user_id_to,

		    @Parameter(description = "Amount of money to transfer")
		    @PathVariable("transferMoney") double transferMoney) {


	    return bnkserv.TransferMoney(user_id_from,user_id_to,transferMoney);
	}
	
	
	
	
	
	
}
