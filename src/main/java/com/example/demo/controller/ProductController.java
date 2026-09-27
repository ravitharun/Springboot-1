package com.example.demo.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderModel;
import com.example.demo.service.ProductSerices;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/Products")
public class ProductController {
	
	private ProductSerices productSerices;
	
	public ProductController(ProductSerices productSerices) {
		this.productSerices =productSerices;
	}
//	GetAllProducts
	
	
	@GetMapping("/")

	public ResponseEntity<Map<String, Object>> GetAllProducts() {

		return productSerices.Getprodutcs();
	}

	
//	Add new Product
	@PostMapping("/Add/Product")
	
	public OrderModel AddNewProducts(@Valid @RequestBody OrderModel product) {
		
		
		
		return productSerices.CreateNewprodutcs(product);
	}
	
	
	
	@PostMapping("/Add/Products")
	
	public List<OrderModel> AddMultipleProducts(@Valid @RequestBody List<OrderModel> product) {
		
		
		
		return productSerices.CreateNewMultipleprodutcs(product);
	}
	
	
//	update Products
	@PutMapping("/update/Product")
	
	public String UpdateProducts() {
		
		
		
		return "Updating The Products";
	}
	
}
