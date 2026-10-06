package com.example.demo.model;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userid;

//    @NotNull
    private String username;

    @Email
    @Column(unique = true)
    private String useremail;
    
    
    
//    
    @OneToMany
    @JoinColumn(name = "userid")
    private List<Cart> cartItems;
//    
    
    
    @OneToOne(mappedBy = "user")
    private UserProfileModel profile;

    
    
    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 60, message = "Age must be at most 60")
    private int userage;

    @Size(min = 5,message = "password length >", max = 200)
//    @Pattern(regexp = "^[A-za-z0-9]{10}$")
    private String userpassword;

    
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
    // username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // useremail
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    // userpassword
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    // userage
    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

	public UserProfileModel getProfile() {
		// TODO Auto-generated method stub
		return profile;
	}



	public List<Cart> getCartItems() {
		// TODO Auto-generated method stub
		return cartItems;
	}
}