package com.example.movie_java_server.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer operation_ID;
	private Integer admin_ID;
	private String password;
	
	public Admin() {};
	public Admin(Integer operationid, Integer adminid, String password) {
		this.admin_ID = adminid;
		this.operation_ID = operationid;
		this.password = password;
	}
	
	public Integer getAdmin_ID() {
		return admin_ID;
	}
	public void setAdmin_ID(Integer admin_ID) {
		this.admin_ID = admin_ID;
	}
	public Integer getOperation_ID() {
		return operation_ID;
	}
	public void setOperation_ID(Integer operation_ID) {
		this.operation_ID = operation_ID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
