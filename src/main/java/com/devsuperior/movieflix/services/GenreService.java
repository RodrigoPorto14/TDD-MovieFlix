package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	GenreRepository genreRep;
	
	public List<GenreDTO> findAll()
	{
		List<Genre> genres = genreRep.findAll();
		return genres.stream().map(g -> new GenreDTO(g)).toList();
	}
}
