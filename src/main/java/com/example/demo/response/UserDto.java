
package com.example.demo.response;

public class UserDto {

    private int userid;
    private int userage;
    private String username;
    private String useremail;

    // Getters
    public int getUserid() {
        return userid;
    }

    public int getUserage() {
        return userage;
    }

    public String getUsername() {
        return username;
    }

    public String getUseremail() {
        return useremail;
    }

    // Setters
    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}