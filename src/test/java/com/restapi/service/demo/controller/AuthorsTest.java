package com.restapi.service.demo.controller;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.service.demo.domain.Author;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthorsTest {

    @Autowired
    private MockMvc mockMvc;

      //@Test
    public void testGetAuthors() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/authors")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                //.andReturn().getResponse().getContentAsString()
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty());
    }

      //@Test
    public void testGetAuthorById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/authors/5")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                //.andReturn().getResponse().getContentAsString()
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber());
    }

    //@Test
    public void testPotsAuthor() throws Exception {
        Author author = new Author();
        author.setName("Joe Hill");
        author.setGenre("Horror");
        author.setCountry("USA");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/authors")
                .content(asJsonString(author))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
        //  .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/authors/32")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                //.andReturn().getResponse().getContentAsString()
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(status().is(200));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber());
    }
}
