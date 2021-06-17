package com.example.chatdemo.repository;

import com.example.chatdemo.entity.A00352115messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface A00352115messagesRepository extends JpaRepository<A00352115messages, Long>, JpaSpecificationExecutor<A00352115messages> {
    List<A00352115messages> findByChatId(String chatId);
}