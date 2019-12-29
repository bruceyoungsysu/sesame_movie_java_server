package com.example.movie_java_server.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_java_server.repositories.AdminRepo;
import com.example.movie_java_server.model.Admin;
import com.example.movie_java_server.model.Movie;


@RestController
@CrossOrigin(origins="https://vast-beyond-22805.herokuapp.com/")
public class AdminService {
	@Autowired
	AdminRepo adminRepo;
	
	@PostMapping("/api/adminlogin")
	public void AdminLogin(@RequestBody Integer adminid, HttpSession session) {
		session.setAttribute("adminid", adminid);
	}
	
	@PostMapping("/api/addadmin")
	public Admin AddAdmin(@RequestBody Integer optid, HttpSession session) {
		Admin adm = new Admin();
		Integer admid = (Integer)session.getAttribute("adminid");
		adm.setAdmin_ID(admid);
		adm.setOperation_ID(optid);
		return adminRepo.save(adm);
	}
	
	@PostMapping("/api/addAdmin")
	public List<Admin> addAdmin(@RequestBody Admin admin) {
		adminRepo.save(admin);
		return (List<Admin>) adminRepo.findAll();
	}
	
	@DeleteMapping("/api/admin/delete/{id}")
	public List<Admin> deleteAdmin(@PathVariable("id") Integer id) {
		adminRepo.deleteById(id);
		return (List<Admin>) adminRepo.findAll();
	}
	
	@GetMapping("/api/admins")
	public List<Admin> findAllAdmins(){
		return (List<Admin>) adminRepo.findAll();
	}
}
