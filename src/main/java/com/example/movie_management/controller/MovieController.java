package com.example.movie_management.controller;

import com.example.movie_management.model.Movie;
import com.example.movie_management.services.MovieService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie addMovie(@Valid @RequestBody MovieRequest request) {
        return movieService.addMovie(
                request.title(),
                request.rating()
        );
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
