package com.example.movie_management.services;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {
    public String generateDescription(String title) {
        try(Client client = new Client()) {
            String prompt = "Write a short, engaging movie " +
                    "description for the movie titled: " + title +
                    ". Keep it to 2-3 sentences.";

            GenerateContentResponse response = client.models.generateContent(
                    "gemini-3.8-flash",
                           prompt,
                    null
            );
            return response.text();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Unable to generate movie description: " + e.getMessage(), e
            );
        }
    }
}
