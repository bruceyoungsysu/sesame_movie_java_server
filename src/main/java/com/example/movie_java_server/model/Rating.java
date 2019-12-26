package com.example.movie_java_server.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import com.example.movie_java_server.model.MyKey;


@Entity
public class Rating {
    
	@EmbeddedId
	private MyKey key;
	@Column(name="User_rating")
	private Integer rating;
	@Column(name="like")
	private Integer like;
	
	public Rating() {};
	public Rating(MyKey mykey, Integer rating,Integer like) {
	    this.key = mykey;
	    this.rating = rating;
        this.like = like;
	}
	
	public Rating(Integer movieid, Integer userid, Integer rating, Integer like) {
		MyKey key = new MyKey(movieid, userid);
		this.key = key;
		this.rating = rating;
		this.like = like;
	}
	
	public MyKey getKey() {
		return key;
	}
	public void setKey(MyKey key) {
		this.key = key;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getLike() {
		return like;
	}
	public void setLike(Integer like) {
		this.like = like;
	}
}
