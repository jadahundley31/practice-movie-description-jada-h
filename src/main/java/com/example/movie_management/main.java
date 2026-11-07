package com.example.movie_management;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.apache.http.HttpException;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws HttpException, IOException {
        Client client = new Client();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a movie title: with its rating:");
        String title = scanner.nextLine();

        System.out.println("Enter a movie rating:");
        String rating = scanner.nextLine();

        String query = "Write a short movie description for " + title +
                       ". The user's rating is " + rating + " out of 5.";

        GenerateContentResponse response = client.models.generateContent(
                "gemini-3.8-flash",
                       query,
                null
        );

        System.out.println(response.text());
        scanner.close();
    }
}
