package cjc;

import java.util.Date;

public class UserDetails  {
	String username , password , firstname , lastname ,emailId , g;
	Date dob ;
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserDetails(){
		username = password = firstname= lastname = emailId = g = null ;
		dob = null ;
	}
	

}
