package com.example.demo.service;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RepoCart;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Cart;
//import com.example.demo.model.OrderModel;
import com.example.demo.model.UserModel;
import com.example.demo.response.CartDto;
import com.example.demo.response.ErrorResponse;
import com.example.demo.response.SuccessResponse;

@Service
public class CartServices {
	@Autowired 
	private RepoCart repoTOcart;
	
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<SuccessResponse> User_AddCart(CartDto userOrder) {
		
		SuccessResponse sc=new SuccessResponse();
		Cart c=new Cart();
		c.setPid(userOrder.getPid());
		c.setUserid(userOrder.getUserid());
		
		repoTOcart.save(c);
		CartDto cart=new CartDto();
		cart.setPid(userOrder.getPid());
		cart.setUserid(userOrder.getUserid());
		sc.setCode(200);
		sc.setData(cart);
		sc.setMessage("added to cart");
		
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
//	get the all CartItems
	
	

	public ResponseEntity<?> getUserCartItems(long userid) {

		
		ErrorResponse err=new ErrorResponse();
		
	    UserModel user = userRepository.findById(userid).orElse(null);

	    if (user == null) 
	    {
	    	err.setCode(400);
			err.setMessage("user id not fund");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	    }

	    List<Cart> cartItems = user.getCartItems();

//	    return ResponseEntity.ok(cartItems);
	    return ResponseEntity.status(HttpStatus.OK).body(cartItems);
	    
	}
	
	
	public ResponseEntity<?> getUserorder_services(){
		
		
		List<UserModel> user_order_data = userrepo.findUsersWithOrders();
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(user_order_data);
	}



}
