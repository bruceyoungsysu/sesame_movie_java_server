package com.example.movie_java_server.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie_java_server.model.Admin;
import com.example.movie_java_server.model.Operation;
import com.example.movie_java_server.repositories.OperationRepo;

@RestController
@CrossOrigin(origins="https://sesame-movie.herokuapp.com/", allowCredentials = "true", allowedHeaders = "*")
public class OperationService {
	@Autowired
	OperationRepo optRepo;
	
	@GetMapping("/api/opts")
	public List<Operation> findAllOpts(){
		return (List<Operation>) optRepo.findAll();
	}
	
	@PostMapping("/api/addopt")
	public Operation addOpt(@RequestBody Operation opt, HttpSession session) {
		return optRepo.save(opt);
	}

}
