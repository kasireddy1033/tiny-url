package com.url.shortner.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
public class UrlShortnerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	//Tests for POST API
	@Test
	public void postApiTest() throws UnsupportedEncodingException, Exception {
				
	}
	
	@Test
	public void postApiTestForDuplicateUrls() throws UnsupportedEncodingException, Exception {
		
	}
	
	
	//Tests for GET API
	@Test
	public void getApiTest() throws UnsupportedEncodingException, Exception {
		//assertEquals(mockMvc.perform(MockMvcRequestBuilders.get("/aaaaaaa").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString().length(), 7);
	}
	

}
