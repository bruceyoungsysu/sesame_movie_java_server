package com.example.movie_java_server.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer movie_ID;
	private String title;
	private Integer budget;
//	private Date releaseDate;
//	private Time runtime;
	private String status;
	private String productionComp;
	private Integer imdb_ID;
	private Integer tmpd_ID;
	private Float popularity;
	
	public Movie() {};
	public Movie(Integer movieid, String title, Integer budget, Date realeasedate, Time runtime, String status,
			String productcomp, Integer imdb, Integer tmpd, Float popularity){
		this.movie_ID = movieid;
		this.title = title;
		this.budget = budget;
//		this.releaseDate = realeasedate;
//		this.runtime = runtime;
		this.status = status;
		this.productionComp = productcomp;
		this.imdb_ID = imdb;
		this.tmpd_ID = tmpd;
		this.popularity = popularity;
	}
	public Integer getMovieID() {
		return movie_ID;
	}
	public void setMovieID(Integer movieID) {
		this.movie_ID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
//	public Date getReleaseDate() {
//		return releaseDate;
//	}
//	public void setReleaseDate(Date releaseDate) {
//		this.releaseDate = releaseDate;
//	}
//	public Time getRuntime() {
//		return runtime;
//	}
//	public void setRuntime(Time runtime) {
//		this.runtime = runtime;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductionComp() {
		return productionComp;
	}
	public void setProductionComp(String productionComp) {
		this.productionComp = productionComp;
	}
	public Integer getImdbID() {
		return imdb_ID;
	}
	public void setImdbID(Integer imdbID) {
		this.imdb_ID = imdbID;
	}
	public Integer getTmpdID() {
		return tmpd_ID;
	}
	public void setTmpdID(Integer tmpdID) {
		this.tmpd_ID = tmpdID;
	}
	public Float getPopularity() {
		return popularity;
	}
	public void setPopularity(Float popularity) {
		this.popularity = popularity;
	}
	
	
}
