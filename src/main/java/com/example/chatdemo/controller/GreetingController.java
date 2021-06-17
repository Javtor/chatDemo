package com.example.chatdemo.controller;

import com.example.chatdemo.entity.A00352115messages;
import com.example.chatdemo.entity.Greeting;
import com.example.chatdemo.entity.HelloMessage;
import com.example.chatdemo.repository.A00352115messagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;
import java.util.List;

@Controller
public class GreetingController {
    private A00352115messagesRepository repository;
    private SimpMessagingTemplate messagingTemplate;

    public GreetingController(A00352115messagesRepository repository, SimpMessagingTemplate messagingTemplate) {
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat")
    public void greeting(A00352115messages message) throws InterruptedException {
//        Thread.sleep(1000);
        message.setCreatedAt(new Date());
        A00352115messages result = repository.saveAndFlush(message);
        System.out.println(message.getChatId());
        messagingTemplate.convertAndSendToUser(message.getChatId(), "/messages", repository.findByChatId(message.getChatId()));
//        repository.flush();
//        return repository.findAll();
    }


}
