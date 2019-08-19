package com.restapi.service.demo.service;

import com.restapi.service.demo.domain.Author;
import com.restapi.service.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAllAuthors() {

        List<Author> authors = new ArrayList<>();
        authorRepository.findAll ()
                .forEach(authors::add);
        return authors;
    }
    public Optional<Author> getAuthor(int id) {
        return authorRepository.findById(id);
    }

    public void addAuthor(Author author) {

        authorRepository.save(author);
    }

    public void updateAuthor(int id, Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}



