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
import com.example.movie_java_server.repositories.LikeRepo;
import com.example.movie_java_server.model.Like;
import com.example.movie_java_server.model.User;

@RestController
@CrossOrigin(origins="https://sesame-movie.herokuapp.com", allowCredentials = "true", allowedHeaders = "*")
public class LikeService {
	@Autowired
	LikeRepo LikeRepo;
	
	@GetMapping("/api/likes")
    public List<Like> findAllLikes(){
		return (List<Like>) LikeRepo.findAll();
	}
	
	@GetMapping("/api/likes/{movieid}")
	public Like findLikeByID(@PathVariable("movieid") int movie_id, HttpSession session){
		User curUser = (User)session.getAttribute("curuser");
		if(curUser == null) {
			return null;
		}
		List<Like> likes = (List<Like>)LikeRepo.findAll();
		for(Like l: likes) {
			if(l.getMovie_ID() == movie_id && l.getUser_ID() == curUser.getUserID()) {
				return l;
			}
		}
		return null;
	}
	
	@PostMapping("/api/likes/{movieid}")
	public Like saveLikeBy(@PathVariable("movieid") int movie_id, 
			@RequestBody Boolean new_like,
			HttpSession session) {
		User curUser = (User)session.getAttribute("curuser");
		if(curUser == null) {
			return null;
		}
		List<Like> likes = (List<Like>)LikeRepo.findAll();
		for(Like l: likes) {
			if(l.getMovie_ID() == movie_id && l.getUser_ID() == curUser.getUserID()) {
				l.setLike(new_like);
				System.out.println(new_like);
				return LikeRepo.save(l);
			}
		}
		Like l = new Like();
		l.setMovie_ID(movie_id);
		l.setUser_ID(curUser.getUserID());
		l.setLike(new_like);
		return LikeRepo.save(l);
	}

}
