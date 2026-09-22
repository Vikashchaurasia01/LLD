package com.lld;

import java.util.ArrayList;
import java.util.List;

public class Show {
    
    int showId;
    Movie movie;
    Screen screens;
    int showStartTime;
    List<Integer> bookedSeatIds = new ArrayList<>();

    public Show(int showId, Movie movie, Screen screens, int showStartTime) {
        this.showId = showId;
        this.movie = movie;
        this.screens = screens;
        this.showStartTime = showStartTime;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreens() {
        return screens;
    }

    public void setScreens(Screen screens) {
        this.screens = screens;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }
}
