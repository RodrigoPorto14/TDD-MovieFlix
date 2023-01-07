package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;

public class MovieWithoutReviewsDTO extends MovieWithoutSynopsisGenreReviewsDTO{
	private static final long serialVersionUID = 1L;

	private String synopsis;
	private GenreDTO genre;
	
	public MovieWithoutReviewsDTO() {}

	public MovieWithoutReviewsDTO(Movie entity) {
		super(entity);
		synopsis = entity.getSynopsis();
		genre = new GenreDTO(entity.getGenre());
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public String getSynopsis() {
		return synopsis;
	}
}
