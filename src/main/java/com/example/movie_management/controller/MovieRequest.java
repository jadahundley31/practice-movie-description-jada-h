package com.example.movie_management.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

//represents the info users submit when adding a movie
public record MovieRequest(@NotBlank String title, @Min(1) @Max(5) int rating) {
}
