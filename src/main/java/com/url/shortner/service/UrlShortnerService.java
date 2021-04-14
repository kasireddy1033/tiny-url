package com.url.shortner.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.url.shortner.exception.TinyUrlNotFoundException;

public interface UrlShortnerService {
	public String getShorterUrl(JsonNode body);
	public String getUrlUsingShortKey(String id) throws TinyUrlNotFoundException;
}
