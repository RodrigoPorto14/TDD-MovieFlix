package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieWithoutReviewsDTO;
import com.devsuperior.movieflix.dto.MovieWithoutSynopsisGenreReviewsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRep;
	
	@Autowired
	GenreRepository genreRep;
	
	@Autowired
	ReviewRepository reviewRep;
	
	public Page<MovieWithoutSynopsisGenreReviewsDTO> findByGenre(Long genreId, Pageable pageable)
	{
		Genre genre = (genreId != 0) ? genreRep.getOne(genreId) : null;
		return movieRep.findByGenre(genre, pageable);
	}
	
	public MovieWithoutReviewsDTO findById(Long id)
	{
		Movie movie = movieRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieWithoutReviewsDTO(movie);
	}
	
	public List<ReviewDTO> findReviews(Long id)
	{
		Movie movie = movieRep.getOne(id);
		return reviewRep.findAllByMovie(movie).stream().map(r -> new ReviewDTO(r)).toList();
	}
}
