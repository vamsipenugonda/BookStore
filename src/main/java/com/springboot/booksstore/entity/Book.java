package com.springboot.booksstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "bookname")
    String name;
    @Column(name = "author")
    String author;
    @Column(name = "publication")
    String publication;
    @Column(name = "size")
    int pages;
    @Column(nullable = false,name = "price")
    int price;

}
