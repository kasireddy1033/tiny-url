package com.url.shortner.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.url.shortner.data.TinyUrl;
import com.url.shortner.exception.TinyUrlNotFoundException;
import com.url.shortner.repository.TinyUrlRepository;
import com.url.shortner.service.UrlShortnerService;

import net.bytebuddy.utility.RandomString;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService {

	@Autowired
	TinyUrlRepository tinyUrlRepository;
	
	//expiry, distributed cache can be implemented
	HashMap<String, TinyUrl> cacheData = new HashMap<>();
	
	@Override
	public String getShorterUrl(JsonNode body) {
		//validate url
		String url = body.get("url").asText();
		Optional<TinyUrl> tinyUrlData = tinyUrlRepository.findByUrl(url);
		if(tinyUrlData.isPresent()) {
			//compare for expiry
			return tinyUrlData.get().getId();
		} else {
			TinyUrl tinyUrl = new TinyUrl();
			tinyUrl.setId(generateId());
			tinyUrl.setUrl(url);
			tinyUrl.setCreatedOn(new Date());
			//expiry time set to 5 days
			tinyUrl.setExpiryDate(new Date(System.currentTimeMillis() + 24*60*60*1000*5));
			tinyUrl.setUsername("kasi");
			TinyUrl finalTinyUrl = tinyUrlRepository.save(tinyUrl);
			cacheData.put(finalTinyUrl.getId(), finalTinyUrl);
			return finalTinyUrl.getId();
		}
	}

	private String generateId() {
		while(true) {
			String str =  RandomString.make(7);
			if(cacheData.get(str)==null) {
				return str;
			}
		}
	}

	@Override
	public String getUrlUsingShortKey(String id) throws TinyUrlNotFoundException {
		TinyUrl tinyUrl = cacheData.get(id);
		if(tinyUrl!=null) {
			return tinyUrl.getUrl();
		}
		Optional<TinyUrl> tinyUrlData = tinyUrlRepository.findById(id);
		if(tinyUrlData.isPresent()) {
			return tinyUrlData.get().getUrl();
		} else {
			throw new TinyUrlNotFoundException("Url not found");
		}
	}

}
