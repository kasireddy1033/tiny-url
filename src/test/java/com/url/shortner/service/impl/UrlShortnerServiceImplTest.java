package com.url.shortner.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.url.shortner.data.TinyUrl;
import com.url.shortner.exception.TinyUrlNotFoundException;
import com.url.shortner.repository.TinyUrlRepository;
import com.url.shortner.service.UrlShortnerService;

@SpringBootTest
public class UrlShortnerServiceImplTest {

	@Autowired
	UrlShortnerService urlShortnerService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void getShorterUrlTest() {
		ObjectNode jsonNode = mapper.createObjectNode();
		String url = "https://dell.com/11111111111111111111";
		jsonNode.put("url", url);
		String shortKey = urlShortnerService.getShorterUrl(jsonNode);
		assertEquals(shortKey.length(), 7);
		String newShortKey = urlShortnerService.getShorterUrl(jsonNode);
		assertEquals(newShortKey, shortKey);
		newShortKey = urlShortnerService.getShorterUrl(jsonNode);
		assertEquals(newShortKey, shortKey);
	}
	
	
	@Test
	public void getUrlUsingShortKeyTest() throws TinyUrlNotFoundException {
//		TinyUrlRepository tinyUrlRepository = Mockito.mock(TinyUrlRepository.class);
//		TinyUrl resp = new TinyUrl();
//		when(tinyUrlRepository.save(Mockito.any())).thenReturn(resp);
//		when(tinyUrlRepository.findById(Mockito.any())).thenReturn(null);
		ObjectNode jsonNode = mapper.createObjectNode();
		String url = "https://dell.com/11111111111111111111";
		jsonNode.put("url", url);
		String shortKey = urlShortnerService.getShorterUrl(jsonNode);
		assertEquals(urlShortnerService.getUrlUsingShortKey(shortKey), url);
		urlShortnerService.getShorterUrl(jsonNode);
		urlShortnerService.getShorterUrl(jsonNode);
		assertEquals(urlShortnerService.getUrlUsingShortKey(shortKey), url);
	}
}
