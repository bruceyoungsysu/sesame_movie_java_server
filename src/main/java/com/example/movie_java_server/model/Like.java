package com.example.movie_java_server.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="upvote")
public class Like {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer like_ID;
	
	private Integer movie_ID;
	private Integer user_ID;
	
	private Boolean upvote;
	
	public Like() {};
	public Like( Integer like_ID, Integer movie_ID, Integer user_ID, Boolean Like){
		this.like_ID = like_ID;
		this.movie_ID = movie_ID;
		this.user_ID = user_ID;
		this.upvote = Like;
	}

	public Integer getLike_ID() {
		return like_ID;
	}

	public void setLike_ID(Integer like_ID) {
		this.like_ID = like_ID;
	}

	public Integer getMovie_ID() {
		return movie_ID;
	}

	public void setMovie_ID(Integer movie_ID) {
		this.movie_ID = movie_ID;
	}

	public Integer getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(Integer user_ID) {
		this.user_ID = user_ID;
	}

	public Boolean getLike() {
		return upvote;
	}

	public void setLike(Boolean like) {
		this.upvote = like;
	}
}
