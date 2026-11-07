package com.example.movie_management.model;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int rating;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Movie(){}

    public Movie(String title, int rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }
}
