package com.restapi.service.demo.controller;

import com.restapi.service.demo.domain.Author;
import com.restapi.service.demo.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

        @Autowired
        private AuthorsService authorsService;

        @RequestMapping("/authors")
        public List<Author> getAllAuthors() {

            return authorsService.getAllAuthors();
        }
        @RequestMapping("/authors/{id}")
        public Optional<Author> getAuthor(@PathVariable int id) {
            return authorsService.getAuthor(id);
        }

        @RequestMapping(method = RequestMethod.POST, value = "/authors")
        public void addAuthor(@RequestBody Author author) {
            authorsService.addAuthor(author);
        }

        @RequestMapping(method = RequestMethod.PUT, value = "/authors/{id}")
        public void updateAuthor(@RequestBody Author author, @PathVariable int id) {
            authorsService.updateAuthor(id, author);
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "/authors/{id}")
        public void deleteAuthor(@PathVariable int id) {
            authorsService.deleteAuthor(id);
        }
    }


