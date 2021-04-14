package com.url.shortner.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import com.sun.istack.NotNull;

@Entity
@Scope("prototype")
@Table(name = "tinyurl")
public class TinyUrl {
	
	@Id
    @NotNull
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String id;

    @NotNull
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "username")
    private String username;
    
    
    @NotNull
    @Column(name = "createdOn")
    private Date createdOn;
    
    @NotNull
    @Column(name = "expiryDate")
    private Date expiryDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
    
    
    

}
