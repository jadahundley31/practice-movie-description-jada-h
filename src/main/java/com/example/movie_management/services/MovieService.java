package com.example.movie_management.services;

import com.example.movie_management.model.Movie;
import com.example.movie_management.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //tells Spring Boot that MovieService contains business logic and should be managed by Spring.
public class MovieService {
    private final MovieRepository movieRepository;
    private final GeminiService geminiService;

    public MovieService(MovieRepository movieRepository, GeminiService geminiService) {
        this.movieRepository = movieRepository;
        this.geminiService = geminiService;
    }
    //Spring Boot automatically provides the MovieRepository object when creating the service (dependency injection).
    public Movie addMovie(String title, int rating) {
        String description = geminiService.generateDescription(title);
        Movie movie = new Movie(title, rating, description);
        return movieRepository.save(movie);
    }//method creates a new Movie object and saves it to MySQL.

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }//method retrieves all movies stored in the MySQL database.
}
