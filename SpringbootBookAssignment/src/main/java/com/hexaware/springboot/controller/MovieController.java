package com.hexaware.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springboot.model.Movie;

@RestController
public class MovieController {
	
	static ArrayList<Movie> movies=new ArrayList<>();
	MovieController()
	{
		movies.add(new Movie(101,"KGF","Yash",9.5));
		movies.add(new Movie(102,"Pushpa","Allu Arjun",8.9));
	}
	@PostMapping("/addMovie")
	String addMovie(@RequestBody Movie m)
	{
		movies.add(m);
		return "Movie added";
	}
	
	@GetMapping("/showAllMovies")
	List<Movie> showAll()
	{
		return movies;
	}
	@GetMapping("/searchMovie/{id}")
	Movie searchById(@PathVariable int id)
	{
		for(Movie m:movies)
		{
			if(m.getMovieId()==id)
			{
				return m;
			}
		}
		return null;
	}
	 @DeleteMapping("/deleteMovie/{id}")
	 String deleteMovie(@PathVariable int id) {
	        for (Movie m:movies) {
	            if (m.getMovieId() == id) {
	                movies.remove(m);
	                return "Movie Deleted Successfully";
	            }
	        }
	        return "Movie Not Found";
	    }
	 @PutMapping("/updateMovie/{id}")
	 String updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {
	     for (Movie m:movies) {
	         if (m.getMovieId() == id) {
	             m.setMovieName(updatedMovie.getMovieName());
	             m.setHero(updatedMovie.getHero());
	             m.setRatings(updatedMovie.getRatings());
	             return "Movie Updated Successfully";
	         }
	     }
	     return "Movie Not Found";
	 }
	 @GetMapping("/topMovie")
	 public Object topRatedMovie() {
	     if (movies.isEmpty()) {
	         return "No Movies Available";
	     }

	     Movie top = movies.get(0);

	     for (Movie m : movies) {
	         if (m.getRatings() > top.getRatings()) {
	             top = m;
	         }
	     }

	     return top;
	 }
	 @GetMapping("/searchhero/{hero}")
	 public Object searchByHero(@PathVariable String hero) {
	     List<Movie> result = new ArrayList<>();

	     for (Movie m : movies) {
	         if (m.getHero().equalsIgnoreCase(hero)) {
	             result.add(m);
	         }
	     }

	     if (result.isEmpty()) {
	         return "No Movies Found For Hero";
	     }

	     return result;
	 }
}
