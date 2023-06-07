package com.JavaCrud.RestApiExample.repository;

import com.JavaCrud.RestApiExample.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ServerRepository
    extends MongoRepository<Server, Integer> {
        List<Server> findByName(String name);   
}
