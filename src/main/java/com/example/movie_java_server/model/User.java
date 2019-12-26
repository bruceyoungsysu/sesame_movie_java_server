package com.example.movie_java_server.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ID;
	@Column(name="name")
	private String Name;
	private String password;
	@Column(name="email")
	private String email;
	
//	@OneToMany(mappedBy="user")
//    private List<Course> courses;
	
	public User(){};
	
	public User(Integer userid, String username, String password, String email) {
		this.ID = userid;
		this.Name = username;
		this.password = password;
		this.email = email;
	}

	public Integer getUserID() {
		return ID;
	}

	public void setUserID(Integer userID) {
		this.ID = userID;
	}

	public String getUserName() {
		return Name;
	}

	public void setUserName(String userName) {
		this.Name = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
