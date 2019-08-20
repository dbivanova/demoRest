package com.restapi.service.demo.controller;

import com.restapi.service.demo.domain.Author;
import com.restapi.service.demo.service.AuthorsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Authors Management System", description = "Sample Description of my REST service")

public class AuthorController {

    @Autowired
    private AuthorsService authorsService;

    @ApiOperation(value = "View a list of available authors and books", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {

        return authorsService.getAllAuthors();
    }

    @ApiOperation(value = "View specific author and their books")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/authors/{id}")
    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public Optional<Author> getAuthor(@PathVariable int id) {
        return authorsService.getAuthor(id);
    }

    @ApiOperation(value = "Add an author")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created entry"),
            @ApiResponse(code = 401, message = "You are not authorized to perform this operation"),
            @ApiResponse(code = 403, message = "Operation is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/authors")
    @RequestMapping(method = RequestMethod.POST, value = "/authors")
    public void addAuthor(@RequestBody Author author) {
        authorsService.addAuthor(author);
    }

    @ApiOperation(value = "Edit an existing author or book")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated entry"),
            @ApiResponse(code = 401, message = "You are not authorized to perform this operation"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("/authors/{id}")
    @RequestMapping(method = RequestMethod.PUT, value = "/authors/{id}")
    public void updateAuthor(@RequestBody Author author, @PathVariable int id) {
        authorsService.updateAuthor(id, author);
    }

    @ApiOperation(value = "Delete an existing author")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted entry"),
            @ApiResponse(code = 401, message = "You are not authorized to perform this operation"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/authors/{id}")
    @RequestMapping(method = RequestMethod.DELETE, value = "/authors/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorsService.deleteAuthor(id);
    }
}


