package com.JavaCrud.RestApiExample.controller;

import com.JavaCrud.RestApiExample.model.Server;
import com.JavaCrud.RestApiExample.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ServerController {
    
    @Autowired
    private ServerRepository repo;

    @GetMapping("/Servers/{id}")
    public ResponseEntity<Optional<Server>> getServerById(@PathVariable("id") int id) {
        log.info("getServer with "+Integer.toString(id));
        Optional<Server> response = repo.findById(id);
        if (!response.isPresent()){
            return new ResponseEntity<Optional<Server>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Server>>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/Servers")
    public ResponseEntity<List<Server>> getServer() {
        log.info("Gets all server");
        List<Server> response = repo.findAll();
        if (response.isEmpty()){
            return new ResponseEntity<List<Server>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Server>>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/Servers_with_name/{name}")
    public ResponseEntity<List<Server>> getServerByName(@PathVariable("name")  String serverName) {
        log.info("getServer with server name : "+serverName);
        List<Server> response = repo.findByName(serverName);
        if(response.isEmpty()){
            return new ResponseEntity<List<Server>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Server>>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/Servers")
    public ResponseEntity<String> createServer(@RequestBody Server server) {
        log.info("setsServer with server name : "+server.toString());
        repo.save(server);
        return new ResponseEntity<String>("created server object ", HttpStatus.CREATED);
    }

    @DeleteMapping("/Servers/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") int id) {
        log.info("deletes Server with server id : "+Integer.toString(id));
        if(repo.findById(id).isPresent()){
            repo.deleteById(id);
            return new ResponseEntity<String>("deleted server object ", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("No server object matching with this id", HttpStatus.ACCEPTED);
    }



}
