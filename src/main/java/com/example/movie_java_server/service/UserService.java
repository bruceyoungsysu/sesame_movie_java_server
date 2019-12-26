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
import com.example.movie_java_server.repositories.UserRepo;
import com.example.movie_java_server.model.Movie;
import com.example.movie_java_server.model.User;


@RestController
@CrossOrigin(origins="*")
public class UserService {
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/api/users")
	public List<User> findAllUsers(){
		return (List<User>) userRepo.findAll();
	}
	
//	@GetMapping("/api/user/{id}")
//	public Optional<User> findUserByID(@PathVariable("id") Integer id){
//		return userRepo.findById(id);
//	}
	
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) {
		session.setAttribute("curuser", user);
		return userRepo.save(user);
	}
	
	@GetMapping("/api/profile")
	public User profile(HttpSession session) {
		User curUser = (User)session.getAttribute("curuser");
		return curUser;
	}
	
	@PostMapping("/api/login")
	public User login(@RequestBody User user, HttpSession session) {
		List<User> users = this.findAllUsers();
		
		for(User u:users) {
			if(u.getPassword()!= null && u.getPassword().equals(user.getPassword()) 
					&& u.getUserName()!=null && u.getUserName().equals(user.getUserName())) {
				session.setAttribute("curuser", u);
				return u;
			}
		}
		return null;
	}
	
	@GetMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
//	@DeleteMapping("/api/user/delete/{id}")
//	public List<User> deleteUser(@PathVariable("id") Integer id) {
//		userRepo.deleteById(id);
//		return (List<User>) userRepo.findAll();
//	}
	
	@PostMapping("/api/addUser")
	public List<User> addUser(@RequestBody User user) {
		userRepo.save(user);
		return (List<User>) userRepo.findAll();
	}
		
	
}
