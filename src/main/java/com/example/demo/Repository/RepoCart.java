package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cart;

public interface RepoCart extends JpaRepository<Cart, Long >{


	List<Cart> findByuserid(long userid);

}
