package com.example.chatdemo.controller;

import com.example.chatdemo.entity.A00352115messages;
import com.example.chatdemo.repository.A00352115messagesRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RestController {

    private A00352115messagesRepository repository;

    public RestController(A00352115messagesRepository repository){
        this.repository = repository;
    }

    @GetMapping(value = "/damelos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<A00352115messages> damelos(){
        return repository.findAll();
    }
}
