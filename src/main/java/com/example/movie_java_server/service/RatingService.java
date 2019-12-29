package com.example.movie_java_server.service;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_java_server.repositories.RatingRepo;
import com.example.movie_java_server.model.User;
import com.example.movie_java_server.model.MyKey;
import com.example.movie_java_server.model.Rating;

@RestController
@CrossOrigin(origins="https://sesame-movie.herokuapp.com/", allowCredentials = "true", allowedHeaders = "*")
public class RatingService {
	@Autowired
	RatingRepo ratingRepo;
	
	@GetMapping("/api/records/{movieid}")
	public Optional<Rating> findRecordByID(
			@PathVariable("movieid") Integer movieid,
			HttpSession session) {
		User curUser = (User)session.getAttribute("curuser");
		if(curUser == null) {
			return null;
		}
		int userid = curUser.getUserID();
		MyKey key = new MyKey(movieid, userid);
		return ratingRepo.findById(key);
	}
	
	@PostMapping("/api/ratings/editlike/{movieid}")
	public Rating updateLike(@PathVariable("movieid") Integer movieid,
			@RequestBody Integer like, HttpSession session) {
		User curUser = (User)session.getAttribute("curuser");
		int userid = curUser.getUserID();
		MyKey key = new MyKey(movieid, userid);
		Optional<Rating> rating = ratingRepo.findById(key);
		if(rating.isPresent()) {
			Rating r = rating.get();
			r.setLike(like);
			System.out.println(r.getLike());
			return ratingRepo.save(r);
		}
		else {
			// handle corner case here
			return null;
		}
	}
	
	@PostMapping("/api/ratings/add")
	public Rating addRating(@RequestBody Rating record, HttpSession session) {
		User curUser = (User)session.getAttribute("curuser");
		MyKey key = record.getKey();
		System.out.println(key.getUser_id());
		key.setUser_id(curUser.getUserID());
		record.setKey(key);
		return ratingRepo.save(record);
	}
	
	
	@DeleteMapping("/api/rating/delete/{movieid}/{userid}")
	public List<Rating> deleteRating(
			@PathVariable("movieid") Integer mid,
			@PathVariable("userid") Integer uid) {
		MyKey k = new MyKey(mid, uid);
		ratingRepo.deleteById(k);
		return (List<Rating>) ratingRepo.findAll();
	}
    
}
