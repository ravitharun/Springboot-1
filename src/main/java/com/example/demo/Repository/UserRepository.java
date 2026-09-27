package com.example.demo.Repository;


import com.example.demo.model.UserModel;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface  UserRepository extends JpaRepository<UserModel,Long>{
	boolean existsByUseremail(String useremail);
	
	UserModel findByUsernameAndUseremail(String username, String useremail);
	@Query("SELECT u FROM UserModel u WHERE u.username = :username ANd u.useremail=:useremail")
	UserModel findbyusername(@Param("username") String username,@Param("useremail") String useremail);

}
