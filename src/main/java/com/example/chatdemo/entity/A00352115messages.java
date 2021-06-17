package com.example.chatdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "`A00352115messages`")
public class A00352115messages implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "text", nullable = true)
    private String text;

    @Column
    private String chatId;

    @Column(name = "sender", nullable = true)
    private String sender;

    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @Column(name = "receiver", nullable = true)
    private String receiver;

}
