package com.example.demo.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.UserAge;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserModel;
import  com.example.demo.response.SuccessResponse;
import com.example.demo.response.UserDto;
import com.example.demo.security.JwtService;

@Service
public class UserService {
	@Autowired
	private  UserRepository userRepo;
	@Autowired
	private JwtService jwtService;

	


   
	public ResponseEntity<Map<String, Object>> usercreateAccount(UserModel data) {

    Map<String, Object> response_api = new HashMap<>();

    try {

       
        if (data.getUsername() == null ||
            data.getUsername().trim().isEmpty()) {

            response_api.put("code", 400);
            response_api.put("message", "Name must not be empty");
            response_api.put("status", false);
            return ResponseEntity.status(400).body(response_api);
        }

        // Password validation
        if (data.getUserpassword() == null ||
            data.getUserpassword().length() < 5 ||
            data.getUserpassword().length() > 10) {

            response_api.put("code", 400);
            response_api.put("message", "Password must be between 5 and 10 characters");
            response_api.put("status", false);

            return ResponseEntity.status(400).body(response_api);
        }

        // Check email already exists
        boolean isExists =
                userRepo.existsByUseremail(data.getUseremail());

        if (isExists) {

            response_api.put("code", 409);
            response_api.put(
                "message",
                "This email is already registered: " + data.getUseremail()
            );
            response_api.put("status", false);

            return ResponseEntity.status(409).body(response_api);
        }
       
        // Save user
        UserModel useraccount = userRepo.save(data);
        String token = jwtService.generateToken(useraccount.getUsername());

        response_api.put("code", 201);
        response_api.put("message", "User account created successfully");
        response_api.put("User_account", useraccount);
        response_api.put("token", token);

        return ResponseEntity.status(201).body(response_api);

    } catch (Exception e) {

        response_api.put("code", 500);
        response_api.put(
            "message",
            "Failed to create user account: " + e.getMessage()
        );

        return ResponseEntity.status(500).body(response_api);
    }
}

	
//	get user info by id
	
	
	public ResponseEntity<SuccessResponse> GetUserInfo(long userid) {

	    Optional<UserModel> isuserinfo = userRepo.findById(userid);

	    if (isuserinfo.isEmpty()) {
	        throw new UserNotFoundException("User not found");
	    }

	    UserModel userModel = isuserinfo.get();

	    UserDto user = new UserDto();

//	    user.setUserid(userModel.getUserid());
	    user.setUserage(userModel.getUserage());
	    user.setUsername(userModel.getUsername());
	    user.setUseremail(userModel.getUseremail());

	    SuccessResponse response = new SuccessResponse();

	    response.setCode(200);
	    response.setMessage("User found");
	    response.setData(user);

	    return ResponseEntity.status(200).body(response);
	}





public 	ResponseEntity<Map<String,Object>>userinfo() {
	
	
	
	Map<String, Object>response=new HashMap<>();	
	List<UserModel> users = userRepo.findAll();


	
	List<UserDto> userDtos = new ArrayList<>();
	for (UserModel user : users) {

	    UserDto dto = new UserDto();

//	    dto.setUserid(user.getUserid());
	    dto.setUsername(user.getUsername());
	    dto.setUseremail(user.getUseremail());
	    dto.setUserage(user.getUserage());


	    userDtos.add(dto);
	}
	response.put("code", 200);
	response.put("user_info userDtos", userDtos);
	
	
	
	return ResponseEntity.status(HttpStatus.OK).body(response);
}

public ResponseEntity<SuccessResponse> GetUSERInfo(String username,String useremail) {
	UserModel response_r=userRepo.findByUsernameAndUseremail(username, useremail);
    SuccessResponse response = new SuccessResponse();
// check the user is null
    if (response_r == null) {

        response.setCode(404);

//        response.setCode(
        response.setMessage("User not found");
        response.setData(null);

        return ResponseEntity.status(404).body(response);
    }
	UserDto userdto=new UserDto();
	userdto.setUserage(response_r.getUserage());
	userdto.setUsername(response_r.getUsername());
	userdto.setUseremail(response_r.getUseremail());

    response.setCode(200);
    response.setMessage("userinfo");
    response.setData(userdto);
	return ResponseEntity.status(200).body(response);
}





public ResponseEntity<SuccessResponse> Getuser_INFO_TEST_Query(String username,String useremail) {
	UserModel  user=userRepo.findbyusername(username,useremail);
	SuccessResponse sc=new SuccessResponse();
	if(user==null) {
		sc.setCode(400);
		sc.setData(null);
		sc.setMessage("user not found");
		return ResponseEntity.status(400).body(sc);
		
	}
	UserDto ur=new UserDto();
	ur.setUserage(user.getUserage());
	ur.setUsername(user.getUsername());
	
	sc.setCode(200);
	sc.setData(ur);
	sc.setMessage("user");
	return ResponseEntity.status(200).body(sc);
}


public ResponseEntity<Map<String ,Object>> userEmailCheck(long userid) {
	UserModel user=userRepo.findById(userid).orElseThrow(() -> new UserAge("User not found"+userid));;
	System.err.println(user);
	System.err.println(userid);
	
	System.err.println(user.getUserage());
	System.err.println(user.getUsername());
	System.err.println(user.getUseremail());
	Map <String, Object> mp=new HashMap<>();
	UserDto dto=new UserDto();
	dto.setUserage(user.getUserage());
	dto.setUseremail(user.getUseremail());
	dto.setUsername(user.getUsername());
//	dto.setUserid(1000);
	
	mp.put("code",200);
	mp.put("userinfo", user);
	mp.put("userDto", dto);
	return  ResponseEntity.status(HttpStatus.OK).body(mp);
}
}
