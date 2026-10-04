package com.example.demo.service;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;
//import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
//import org.springframework.http.RequestEntity;
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
	public ResponseEntity<Map<String, Object>> Getprodutcs(Pageable pageable) {
		

		Map<String, Object> response_api=new HashMap<>();
		Page<OrderModel> productsdata=productRepo.findAll(pageable);
		response_api.put("total Products",productsdata.getSize());
		response_api.put("code",HttpStatus.OK);
		response_api.put("message","fetched the all products");
		response_api.put("status",true);
		response_api.put("Products",productsdata);
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
