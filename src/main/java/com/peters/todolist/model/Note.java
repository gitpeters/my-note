package com.peters.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Date;


@Entity
@Data
@Table(name="records")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="title")
    private String title;
    @Column(name="body")
    private String body;
    @Column(name="createdAt")
    private LocalDate createdAt =  LocalDate.now();

//    @PrePersist
//    void createdAt(){
//        this.createdAt =  LocalDate.now();
//    }
}

