package com.example.movie_java_server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MyKey implements Serializable {

    @Column(name = "Movie_ID")
    private int movie_id;

    @Column(name = "User_ID")
    private int user_id;
    
    public MyKey() {};
    
    public MyKey(Integer movieid, Integer userid) {
    	this.movie_id = movieid;
    	this.user_id = userid;
    }

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}   
}
