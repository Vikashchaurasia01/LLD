package com.lld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lld.enums.City;

public class TheatreController {
    Map<City, List<Theatre>> theatresByCity;
    List<Theatre> allTheatres;

    TheatreController() {
        theatresByCity = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {
        allTheatres.add(theatre);

        List<Theatre> theatres = theatresByCity.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        theatresByCity.put(city, theatres);
    }

    Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {

        Map<Theatre, List<Show>> theatreToShowsMap = new HashMap<>();
        List<Theatre> theatres = theatresByCity.getOrDefault(city, new ArrayList<>());

        for(Theatre theatre : theatres) {
            List<Show> shows = theatre.getShows();
            List<Show> givenMoviesShow = new ArrayList<>();

            for(Show show : shows) {
                if(show.movie.getMovieId() == movie.getMovieId()) {
                    givenMoviesShow.add(show);
                }
            }

            if(givenMoviesShow.size() > 0) {
                theatreToShowsMap.put(theatre, givenMoviesShow);
            }
        }
        return theatreToShowsMap;
    }
}