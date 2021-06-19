package com.example.chatdemo.controller;

import com.example.chatdemo.entity.A00352115messages;
import com.example.chatdemo.repository.A00352115messagesRepository;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RestController {

    private A00352115messagesRepository repository;
    private SimpMessagingTemplate messagingTemplate;

    public RestController(A00352115messagesRepository repository, SimpMessagingTemplate messagingTemplate){
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping(value = "/damelos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<A00352115messages> damelos(@PathVariable String id){
        return repository.findByChatId(id);
    }

    @PostMapping(value = "/enviar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public A00352115messages damelos(@PathVariable String id, @RequestBody A00352115messages msg){
        msg.setCreatedAt(new Date());
        A00352115messages result = repository.saveAndFlush(msg);
        messagingTemplate.convertAndSendToUser(result.getChatId(), "/messagesInd", result);
        return result;
    }
}
