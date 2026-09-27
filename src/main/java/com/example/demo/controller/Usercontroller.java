package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class Usercontroller {
	private UserService userService;

	public Usercontroller(UserService userService) {
	    this.userService = userService;
	}
	
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> userLogin(@RequestBody UserModel data) {
        return userService.usercreateAccount(data);

    }

//		    @GetMapping("/userid")
//		    
//		    public ResponseEntity<SuccessResponse> getUser(@Valid @RequestParam("userid") long userid) {
//		    	
//		    	
//		    	return userService.GetUserInfo(userid);
//		    }
//		    
		    
		    
		    
			    @GetMapping("/")
			    public 	ResponseEntity<Map<String, Object>>getAllusers() {
	
			    	
			    	return userService.userinfo();
			    }
			    
			    
			    @GetMapping("/getUser")
			    
			    public ResponseEntity<SuccessResponse> Getuser_info(@RequestParam("username")  String username, @RequestParam("useremail")String useremail) {
			  
			    	
			    	return userService.GetUSERInfo(username,useremail);

			    }
			    
			    
			    @GetMapping("/getuser")
			    
			    public ResponseEntity<SuccessResponse> Getuser_(@RequestParam("username")  String username, @RequestParam("useremail")String useremail) {
			  
			    	
			    	return userService.Getuser_INFO_TEST_Query(username,useremail);
			    }
}