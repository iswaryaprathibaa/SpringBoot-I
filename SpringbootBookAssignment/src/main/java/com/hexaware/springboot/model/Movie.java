package com.hexaware.springboot.model;

public class Movie {
	int movieId;
	String movieName;
	String hero;
	double ratings;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	public Movie(int movieId, String movieName, String hero, double ratings) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.hero = hero;
		this.ratings = ratings;
	}
	public Movie() {
		super();
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", hero=" + hero + ", ratings=" + ratings
				+ "]";
	}
	
}
