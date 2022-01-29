package com.frodolele.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "iso")
    private long iso;

    @Column(name = "stocked")
    private boolean stocked;
}
