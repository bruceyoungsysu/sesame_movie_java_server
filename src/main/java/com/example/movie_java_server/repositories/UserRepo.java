package com.example.movie_java_server.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.movie_java_server.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
