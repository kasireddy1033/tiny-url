package com.url.shortner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.url.shortner.data.TinyUrl;

public interface TinyUrlRepository extends JpaRepository<TinyUrl, String>{

	Optional<TinyUrl> findById(String id);
	
	Optional<TinyUrl> findByUrl(String url);
	
}
