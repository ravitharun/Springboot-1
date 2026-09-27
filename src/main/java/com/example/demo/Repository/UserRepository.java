package com.example.demo.Repository;


import com.example.demo.model.UserModel;



import org.springframework.data.jpa.repository.JpaRepository;
public interface  UserRepository extends JpaRepository<UserModel,Long>{
	boolean existsByUseremail(String useremail);
	
	UserModel findByUsernameAndUseremail(String username, String useremail);

}
