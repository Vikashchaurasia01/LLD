package com.lld;

import java.util.*;

import com.lld.enums.City;
import com.lld.enums.SeatCategory;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to BookMyShow!");
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialise();

        bookMyShow.createBooking(City.BANGALORE, "Bahubali");

        bookMyShow.createBooking(City.MUMBAI, "Inception");
        // Add movies, theatres, shows, and perform bookings as needed
    }

    public void createBooking(City userCity, String movieName) {
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        Movie intrestedMovie = null;

        if (movies.isEmpty()) {
            System.out.println("Movie not found: " + movieName);
            return;
        }

        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                intrestedMovie = movie;
                break;
            }
        }

        Map<Theatre, List<Show>> theatreToShowsMap = theatreController.getAllShows(intrestedMovie, userCity);

        Map.Entry<Theatre, List<Show>> entry = theatreToShowsMap.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        int seatNo = 30;
        List<Integer> bookedSeatIds = interestedShow.getBookedSeatIds();
        if(!bookedSeatIds.contains(seatNo)) {
            bookedSeatIds.add(seatNo);
            
            Booking booking = new Booking();
            List<Seat> bookedSeats = new ArrayList<>();
            for(Seat seat : interestedShow.getScreens().getSeats()) {
                if(seat.getSeatId() == seatNo) {
                    bookedSeats.add(seat);
                    break;
                }
            }
            booking.setBookedSeats(bookedSeats);
            booking.setShow(interestedShow);
        } else {
            System.out.println("Seat number " + seatNo + " is already booked.");
            return;
        }
    }

    private void initialise() {
        createMovies();
        createTheatres();
    }

    private void createTheatres() {
        Movie avengerMovie = movieController.getMovieByName("Avengers");
        Movie inceptionMovie = movieController.getMovieByName("Inception");
        Movie bahubaliMovie = movieController.getMovieByName("Bahubali");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreen(createScreen());
        inoxTheatre.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreen().get(0), avengerMovie, 9);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreen().get(0), inceptionMovie, 18);
        Show inoxNightShow = createShows(3, inoxTheatre.getScreen().get(0), bahubaliMovie, 21);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxShows.add(inoxNightShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrtheatre = new Theatre();
        pvrtheatre.setTheatreId(2);
        pvrtheatre.setScreen(createScreen());
        pvrtheatre.setCity(City.MUMBAI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(4, pvrtheatre.getScreen().get(0), inceptionMovie, 10);
        Show pvrEveningShow = createShows(5, pvrtheatre.getScreen().get(0), bahubaliMovie, 19);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrtheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.BANGALORE);
        theatreController.addTheatre(pvrtheatre, City.MUMBAI);
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        return new Show(showId, movie, screen, showStartTime);
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setId(0);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        // 1 to 40 seats, all of category RECLINER
        for (int i = 1; i <= 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.RECLINER);
            seats.add(seat);
        }

        // 41 to 80 seats, all of category PLATINUM
        for (int i = 41; i <= 80; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        // 81 to 100 seats, all of category GOLD
        for (int i = 81; i <= 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {
        Movie avengerMovie = new Movie();
        avengerMovie.setMovieId(1);
        avengerMovie.setMovieName("Avengers");
        movieController.addMovie(avengerMovie, City.BANGALORE);

        Movie inceptionMovie = new Movie();
        inceptionMovie.setMovieId(2);
        inceptionMovie.setMovieName("Inception");
        movieController.addMovie(inceptionMovie, City.MUMBAI);

        Movie bahubaliMovie = new Movie();
        bahubaliMovie.setMovieId(3);
        bahubaliMovie.setMovieName("Bahubali");
        movieController.addMovie(bahubaliMovie, City.BANGALORE);
    }
}