package com.example.movie_java_server.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.movie_java_server.model.Operation;

public interface OperationRepo extends CrudRepository<Operation, Integer> {

}
