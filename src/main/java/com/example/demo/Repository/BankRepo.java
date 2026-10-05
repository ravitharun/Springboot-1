package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BankModel;
public interface BankRepo extends JpaRepository<BankModel, Long>{


}
