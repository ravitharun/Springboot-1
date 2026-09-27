package com.example.demo.service;

import java.util.*;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepo;
import com.example.demo.model.OrderModel;

@Service
public class ProductSerices {
	private final ProductRepo productRepo;
	ProductSerices(ProductRepo productRepo) {
		
		this.productRepo=productRepo;
		
	}
	
//	Get All Products
	public ResponseEntity<Map<String, Object>> Getprodutcs() {
		
		
		
		
		
		
		
		
		
		Map<String, Object> response_api=new HashMap<>();
		List<OrderModel> productsdata=productRepo.findAll();
		response_api.put("code",200);
		response_api.put("message","fetched the all products");
		response_api.put("status",true);
		response_api.put("Products",productsdata);
		response_api.put("total Products",productsdata.size());
		return ResponseEntity.status(HttpStatus.OK).body(response_api);
	}
	
	
	
//	Add Single Product

		public OrderModel  CreateNewprodutcs(OrderModel product) {
			return productRepo.save(product);
		}

		public List<OrderModel> CreateNewMultipleprodutcs(List<OrderModel> product) {
		    return productRepo.saveAll(product);
		}
}
