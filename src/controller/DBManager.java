package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import model.*;

public class DBManager {
    static private DBManager instance = null;

    private ArrayList<RegisteredUser> users;
    private ArrayList<Ticket> tickets;
    private ArrayList<Coupon> coupons;
    private ArrayList<Payment> payments;

    private Theatre theatre;
    private HashMap<Integer, Double> creditCards;

    private ArrayList<Movie> movies;
    private ArrayList<ShowTime> showTimes;
    private ArrayList<Seat> seats;

    static public DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public DBManager() {
        // Get Data from Database
        users = new ArrayList<RegisteredUser>();
        users.add(new RegisteredUser("user1@test.com", "user1pass", "User", "1"));
        users.add(new RegisteredUser("person2@test.com", "person2pass", "Person", "2"));

        tickets = new ArrayList<Ticket>();
        coupons = new ArrayList<Coupon>();
        creditCards = new HashMap<Integer, Double>();

        movies = new ArrayList<Movie>();
        movies.add(new Movie("Avengers Endgame", "Action", "Superheros fight", "src\\Images\\poster1.jpg"));
        movies.add(new Movie("Black Panther", "Action", "Wakanda Forever!", "src\\Images\\poster2.jpg"));
        movies.add(new Movie("Joker", "Thriller", "Joker's story", "src\\Images\\poster3.jpg"));
        movies.add(new Movie("Star Wars", "Action", "idk", "src\\Images\\poster4.jpg"));
        movies.add(new Movie("Ironman", "Action", "Tony Stark is cool", "src\\Images\\poster5.jpg"));
        movies.add(new Movie("Guardians of the Galaxy: V2", "Action", "I am Groot", "src\\Images\\poster6.jpg"));

        movies.get(0).releaseMovie();
        movies.get(1).releaseMovie();
        movies.get(4).releaseMovie();
        movies.get(5).releaseMovie();

        showTimes = new ArrayList<ShowTime>();
        for (Movie movie : movies) {
            showTimes.add(new ShowTime(LocalDateTime.now(), 10, 10, movie));
            showTimes.add(new ShowTime(LocalDateTime.of(2020, 12, 4, 22, 0), 10, 10, movie));
        }

        seats = new ArrayList<Seat>();
        for (ShowTime st : showTimes) {
            for (int i = 0; i < st.getRowCapacity(); i++) {
                for (int j = 0; j < st.getColCapacity(); j++) {
                    seats.add(new Seat(i, j, 20, st));
                }
            }
        }

        payments = new ArrayList<Payment>();
        theatre = new Theatre("MyTheatre", new Address(1234, "street", "U4K7I2", "calgary", "alberta", "CA"), movies);
    }

    public RegisteredUser getUser(String email) {
        for (RegisteredUser u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public boolean addUser(RegisteredUser user) {
        // Email must be unique
        // Note: This could be more efficient, but not important for this project
        for (RegisteredUser u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                return false;
            }
        }

        users.add(user);
        return true;
    }

    public Ticket getTicket(String ticketID) {
        for (Ticket t : tickets) {
            if (t.getTicketID().equals(ticketID)) {
                return t;
            }
        }
        return null;
    }

    public Coupon getCoupon(String couponID) {
        for (Coupon c : coupons) {
            if (c.getCouponID().equals(couponID)) {
                return c;
            }
        }
        return null;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void cancelTicket(Ticket ticket, Coupon coupon) {
        tickets.remove(ticket);
        coupons.add(coupon);
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<ShowTime> getShowTimes(Movie movie) {
        return movie.getShowTimeList();
    }

    public ArrayList<Seat> getSeats(ShowTime show) {
        return show.getSeatList();
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
