package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BankModel;
//import com.example.demo.response.bankAccountDto;

public interface BankRepo extends JpaRepository<BankModel, Long>{

//	void save(bankAccountDto bank);

}
