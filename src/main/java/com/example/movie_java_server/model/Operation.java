package com.example.movie_java_server.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer operation_ID;
	private Integer user_ID;
	private Integer movie_ID;
	private String opt_type;
	
	public Operation() {};
	public Operation(Integer optid, Integer userid, Integer movieid, String opttype) {
		this.operation_ID = optid;
		this.user_ID = userid;
		this.movie_ID = movieid;
		this.opt_type = opttype;
	}
	
	public Integer getOperation_ID() {
		return operation_ID;
	}
	public void setOperation_ID(Integer operation_ID) {
		this.operation_ID = operation_ID;
	}
	public Integer getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(Integer user_ID) {
		this.user_ID = user_ID;
	}
	public Integer getMovie_ID() {
		return movie_ID;
	}
	public void setMovie_ID(Integer movie_ID) {
		this.movie_ID = movie_ID;
	}
	public String getOpt_type() {
		return opt_type;
	}
	public void setOpt_type(String opt_type) {
		this.opt_type = opt_type;
	}
	
	
}
