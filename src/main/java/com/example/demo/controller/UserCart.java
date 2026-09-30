package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.response.CartDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.CartServices;



@RestController
@RequestMapping("/api/cart")

public class UserCart {
	
	@Autowired
	private CartServices AddtoCart;
	@PostMapping("/Add/Cart")
	public ResponseEntity <SuccessResponse >AddTOCart(
			  @RequestBody CartDto userOrder) {

	    return AddtoCart.User_AddCart(userOrder) ;
	}
	@GetMapping("/getcartitem")
	
	public ResponseEntity<List<Cart>> GetCartItem(@RequestParam("userid") long userid) {
		
		
		
		return AddtoCart.getUserCartItems(userid);
	}
	
	
	
	
	
	
	

}
