package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRep;
	
	@Autowired
	MovieRepository movieRep;
	
	@Autowired
	AuthService authService;
	
	public ReviewDTO insert(ReviewDTO dto)
	{
		Review review = new Review();
		review.setText(dto.getText());
		review.setUser(authService.authenticated());
		review.setMovie(movieRep.getOne(dto.getMovieId()));
		reviewRep.save(review);
		
		return new ReviewDTO(review);
	}
	
}
