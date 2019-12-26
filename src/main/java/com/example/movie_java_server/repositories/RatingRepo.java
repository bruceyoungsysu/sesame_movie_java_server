package com.example.movie_java_server.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.movie_java_server.model.MyKey;
import com.example.movie_java_server.model.Rating;

public interface RatingRepo extends CrudRepository<Rating, MyKey> {

}
