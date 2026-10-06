package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.model.UserProfileModel;
import com.example.demo.response.CartDto;
import com.example.demo.response.ErrorResponse;
import com.example.demo.response.ProfileCreationDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.CartServices;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jdk.jfr.Description;



@RestController
@RequestMapping("/api/cart")

public class UserCart {
	
	@Autowired
	private CartServices AddtoCart;
	@Autowired
	private UserService userService;
	@PostMapping("/Add/Cart")
	public ResponseEntity <SuccessResponse >AddTOCart(
			  @RequestBody CartDto userOrder) {

	    return AddtoCart.User_AddCart(userOrder) ;
	}
	@GetMapping("/getcartitem")
	
	public ResponseEntity<?> GetCartItem(@RequestParam("userid") long userid) {
		
		
		
		return AddtoCart.getUserCartItems(userid);
	}
	
	
	
	
	@PostMapping("/add/Profile")
	
	public ProfileCreationDto AddProfile(@RequestBody ProfileCreationDto userinfo ) {
		
		return userService.NewProfile(userinfo);
	}
	
	@GetMapping("/getProfile")
	
	public ResponseEntity<Map<String, Object>>GetUserProfile(@RequestParam("userid") long userid) {
		
		System.err.println(userid);
		return userService.GetUserInfo_profile(userid);
	}
	
	
	
	@Operation(
			
			summary = "get all user and there cart products"
			)
	
	@GetMapping("/all/user/order")
	
	
	
	public ResponseEntity<?> GetUers_order(){
		
		
		
		
		return AddtoCart.getUserorder_services();
	}
	
	
	
	
	
	

}
