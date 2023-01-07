package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieWithoutReviewsDTO;
import com.devsuperior.movieflix.dto.MovieWithoutSynopsisGenreReviewsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MovieWithoutSynopsisGenreReviewsDTO>> findByGenre(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable)
	{
		return ResponseEntity.ok().body(service.findByGenre(genreId, pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieWithoutReviewsDTO> findById(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<List<ReviewDTO>> findReviews(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(service.findReviews(id));
	}

}
