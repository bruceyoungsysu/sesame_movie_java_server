package com.example.movie_java_server.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.movie_java_server.model.Like;


public interface LikeRepo extends CrudRepository<Like, Integer> {

}
