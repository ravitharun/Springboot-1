package com.example.demo.response;

public class ProfileCreationDto {
	private long user_id;
	private String username;
	private long user_Phone;
	private String useremail;
	private String loc;
	private String Profileurl;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getUser_Phone() {
		return user_Phone;
	}
	public void setUser_Phone(long user_Phone) {
		this.user_Phone = user_Phone;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getProfileurl() {
		return Profileurl;
	}
	public void setProfileurl(String profileurl) {
		Profileurl = profileurl;
	}

}
