package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.dto.MovieWithoutSynopsisGenreReviewsDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
	
	@Query("SELECT new com.devsuperior.movieflix.dto.MovieWithoutSynopsisGenreReviewsDTO(m.id, m.title, m.subTitle, m.year, m.imgUrl) "
	     + "FROM Movie m "
	     + "WHERE :genre IS NULL OR m.genre = :genre "
	     + "ORDER BY m.title")
	Page<MovieWithoutSynopsisGenreReviewsDTO> findByGenre(Genre genre, Pageable pageable);

}
