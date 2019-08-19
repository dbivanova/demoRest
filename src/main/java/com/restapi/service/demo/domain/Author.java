package com.restapi.service.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String genre;
    private String country;

    @OneToMany(targetEntity=Book.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="author_id_fk")
    private List<Book> books;
    public Author() {
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
