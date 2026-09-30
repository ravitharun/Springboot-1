package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RepoCart;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Cart;
import com.example.demo.model.OrderModel;
import com.example.demo.model.UserModel;
import com.example.demo.response.CartDto;
import com.example.demo.response.SuccessResponse;

@Service
public class CartServices {
	@Autowired 
	private RepoCart repoTOcart;
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<SuccessResponse> User_AddCart(CartDto userOrder) {
		
		CartDto cart=new CartDto();
		Cart c=new Cart();
		SuccessResponse sc=new SuccessResponse();
		c.setPid(userOrder.getPid());
		c.setUserid(userOrder.getUserid());
		cart.setPid(userOrder.getPid());
		cart.setUserid(userOrder.getUserid());
		repoTOcart.save(c);
		sc.setCode(200);
		sc.setData(cart);
		sc.setMessage("added to cart");
		
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
//	get the all CartItems
	
	

	public ResponseEntity<List<Cart>> getUserCartItems(long userid) {

	    UserModel user = userRepository.findById(userid).orElse(null);

	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }

	    List<Cart> cartItems = user.getCartItems();

	    return ResponseEntity.ok(cartItems);
	}



}
