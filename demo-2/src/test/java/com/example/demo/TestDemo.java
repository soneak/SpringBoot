package com.example.demo;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


public class TestDemo extends Demo1ApplicationTests{
	
	
	@WebMvcTest(Model.class)
	public class ControllerTests {
		@Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void getAllModel() throws Exception {
	        this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	                .andExpect(status().isOk())
	                .andExpect((ResultMatcher) content().contentType("application/json"))
	                .andExpect(jsonPath("$.description").value("HelloWorld!"))
	                .andExpect(jsonPath("$.id").value("1"));
	      
	    }
	    @Test
	    public void addModel() throws Exception {
	        this.mockMvc.perform(post("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	                .andExpect(status().isOk())
	                .andExpect((ResultMatcher) content().contentType("application/json"))
	                .andExpect(jsonPath("$.description").value("spring boot"))
	                .andExpect(jsonPath("$.id").value("4"));
	      
	} 
	    @Test
	    public void updateModel() throws Exception {
	        this.mockMvc.perform(put("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	                .andExpect(status().isOk())
	                .andExpect((ResultMatcher) content().contentType("application/json"))
	                .andExpect(jsonPath("$.description").value("spring"))
	                .andExpect(jsonPath("$.id").value("3"));
	      
	} 
	    @Test
	    public void deleteModelById() throws Exception {
	        this.mockMvc.perform(delete("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	                .andExpect(status().isOk())
	                .andExpect((ResultMatcher) content().contentType("application/json"))
	                .andExpect(jsonPath("$.description").value("spring boot"))
	                .andExpect(jsonPath("$.id").value("4"));
	      
	}
}}