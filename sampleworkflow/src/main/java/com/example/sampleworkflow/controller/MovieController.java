package com.example.sampleworkflow.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
  @GetMapping
  public List<String> getMovies() {
    return Arrays.asList("Iron Man", "Pirates of the Caribbean", "Sherlock Holmes", "Marvel Avengers","");
  }
}
