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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie_java_server.repositories.MovieRepo;
import com.example.movie_java_server.model.Movie;

@RestController
@CrossOrigin(origins="https://vast-beyond-22805.herokuapp.com/")
public class MovieService {
	@Autowired
	MovieRepo movieRepo;
	
	@GetMapping("/api/movies")
	public List<Movie> findAllMovies(){
		return (List<Movie>) movieRepo.findAll();
	}
	
	@PostMapping("/api/addMovie")
	public List<Movie> addMovie(@RequestBody Movie movie) {
		movieRepo.save(movie);
		return (List<Movie>) movieRepo.findAll();
	}
	
	@DeleteMapping("/api/movie/delete/{id}")
	public List<Movie> deleteMovie(@PathVariable("id") Integer id) {
		movieRepo.deleteById(id);
		return (List<Movie>) movieRepo.findAll();
	}
	
//	@PutMapping("/api/updateMovie")
//	public Movie updateMovie(@RequestBody Movie movie) {
//		List<Movie> movies = this.findAllMovies();
//		for (Movie m: movies) {
//			if(m.getMovieID().equals(movie.getMovieID())) {
//				
//			}
//		}
//
//	}
}
