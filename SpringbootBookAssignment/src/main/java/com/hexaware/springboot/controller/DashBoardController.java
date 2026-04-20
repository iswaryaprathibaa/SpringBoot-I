package com.hexaware.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashBoardController {

    @GetMapping("/dashboard")
    public Map<String, Integer> dashboard() {
        Map<String, Integer> map = new HashMap<>();
        map.put("totalBooks", BookController.books.size());
        map.put("totalMovies", MovieController.movies.size());
        return map;
    }
}