package com.in28minutes.springboot.restfulwedservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Post(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Post() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
