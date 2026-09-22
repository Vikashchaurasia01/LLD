package com.lld;
import java.util.*;

import com.lld.enums.City;

public class MovieController {
    Map<City, List<Movie>> cityToMoviesMap;
    List<Movie> allMovies;

    public MovieController() {
        cityToMoviesMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(Movie movie, City city) {
        allMovies.add(movie);

        List<Movie> movies = cityToMoviesMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityToMoviesMap.put(city, movies);
    }

    Movie getMovieByName(String movieName) {
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city) {
        return cityToMoviesMap.getOrDefault(city, new ArrayList<>());
    }

    public Map<City, List<Movie>> getCityToMoviesMap() {
        return cityToMoviesMap;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setCityToMoviesMap(Map<City, List<Movie>> cityToMoviesMap) {
        this.cityToMoviesMap = cityToMoviesMap;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    //REMOVE movie from a particular city, make use of cityVsMovies map

    //UPDATE movie of a particular city, make use of cityVsMovies map

    //CRUD operation based on Movie ID, make use of allMovies list
}