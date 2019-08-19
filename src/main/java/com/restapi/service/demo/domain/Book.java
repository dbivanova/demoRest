package com.restapi.service.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
   // private String author_id;

    public Book() {

    }
    @JoinColumn(name="author_id_fk")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getAutor_id() {
//        return author_id;
//    }
//
//    public void setAutor_id(String autor_id) {
//        this.author_id = autor_id;
//    }
}
