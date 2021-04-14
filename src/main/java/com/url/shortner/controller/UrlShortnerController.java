package com.url.shortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.url.shortner.exception.TinyUrlNotFoundException;
import com.url.shortner.service.UrlShortnerService;

@RestController
public class UrlShortnerController {

	@Autowired
	UrlShortnerService urlShortnerService;
	
	@Value("${application.baseurl}")
	private String baseUrl;

	@PostMapping("/short-url")
	public String getShorterUrl(@RequestBody JsonNode body) {
		return baseUrl + urlShortnerService.getShorterUrl(body);
	}
	
	@GetMapping("/{id}")
	public String getUrlUsingShortKey(@PathVariable String id) throws TinyUrlNotFoundException {
		return urlShortnerService.getUrlUsingShortKey(id);
	}
}
