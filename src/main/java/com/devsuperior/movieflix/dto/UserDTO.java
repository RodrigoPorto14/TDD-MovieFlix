package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.User;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	
	public UserDTO() {}
	
	public UserDTO(User entity)
	{
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
}
