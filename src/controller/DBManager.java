package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import model.*;

/**
 * This class manages communication between the system and the database. For
 * this assignment, it is also simmulating a real database and holds the theatre
 * data
 * 
 * @author Ahmed Amer, Yassin Bayoumy, Bikramjeet Singh Atwal
 * @version 1.0
 * @since November 30, 2020
 */
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

    /**
     * ensures that only one DBManager is instantiated
     * 
     * @return the DBManager instance
     */
    static public DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    /**
     * The contructor for DBManager. Initializes all theatre data that would be in a
     * database
     */
    public DBManager() {
        // Get Data from Database
        users = new ArrayList<RegisteredUser>();
        users.add(new RegisteredUser("user1@test.com", "user1pass", "User", "1"));
        users.add(new RegisteredUser("person2@test.com", "person2pass", "Person", "2"));

        tickets = new ArrayList<Ticket>();
        coupons = new ArrayList<Coupon>();
        creditCards = new HashMap<Integer, Double>();

        movies = new ArrayList<Movie>();
        movies.add(new Movie("Avengers Endgame", "Action", "Superheros fight", new ImageIcon(getClass().getClassLoader().getResource("poster1.jpg"))));
        movies.add(new Movie("Black Panther", "Action", "Wakanda Forever!", new ImageIcon(getClass().getClassLoader().getResource("poster2.jpg"))));
        movies.add(new Movie("Joker", "Thriller", "Joker's story", new ImageIcon(getClass().getClassLoader().getResource("poster3.jpg"))));
        movies.add(new Movie("Star Wars", "Action", "idk", new ImageIcon(getClass().getClassLoader().getResource("poster4.jpg"))));
        movies.add(new Movie("Ironman", "Action", "Tony Stark is cool", new ImageIcon(getClass().getClassLoader().getResource("poster5.jpg"))));
        movies.add(new Movie("Guardians of the Galaxy: V2", "Action", "I am Groot", new ImageIcon(getClass().getClassLoader().getResource("poster6.jpg"))));

        movies.get(0).releaseMovie();
        movies.get(1).releaseMovie();
        movies.get(4).releaseMovie();
        movies.get(5).releaseMovie();

        showTimes = new ArrayList<ShowTime>();
        for (Movie movie : movies) {
            showTimes.add(new ShowTime(LocalDateTime.now(), 5, 10, movie));
            showTimes.add(new ShowTime(LocalDateTime.of(2020, 12, 4, 22, 0), 5, 10, movie));
        }

        seats = new ArrayList<Seat>();
        for (ShowTime st : showTimes) {
            st.createSeats();
            seats.addAll(st.getSeatList());
        }

        payments = new ArrayList<Payment>();
        theatre = new Theatre("MyTheatre", new Address(1234, "street", "U4K7I2", "calgary", "alberta", "CA"), movies);
    }

    /**
     * Returns the user with the specifc email
     * 
     * @param email the email of the user
     * @return the user object
     */
    public RegisteredUser getUser(String email) {
        for (RegisteredUser u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    /**
     * adds a user to the database
     * 
     * @param user the user to add
     * @return true if the addition was succeful, false otherwise
     */
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

    /**
     * finds the ticket with the specific ticketID in the database
     * 
     * @param ticketID the id of the ticket
     * @return the ticket if it was found, null otherwise
     */
    public Ticket getTicket(String ticketID) {
        for (Ticket t : tickets) {
            if (t.getTicketID().equals(ticketID)) {
                return t;
            }
        }
        return null;
    }

    /**
     * finds the coupon with the specific couponID in the database
     * 
     * @param couponID the id of the coupon
     * @return the coupon if it was found, null otherwise
     */
    public Coupon getCoupon(String couponID) {
        for (Coupon c : coupons) {
            if (c.getCouponID().equals(couponID)) {
                return c;
            }
        }
        return null;
    }

    /**
     * adds a payment to the database
     * 
     * @param payment the payment to add
     */
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    /**
     * adds a ticket to the database
     * 
     * @param ticket
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * removes a ticket from the database and adds a coupon
     * 
     * @param ticket the ticket to remove
     * @param coupon the coupon to add
     */
    public void cancelTicket(Ticket ticket, Coupon coupon) {
        tickets.remove(ticket);
        coupons.add(coupon);
    }

    /**
     * gets theatre information from database
     * 
     * @return the theatre object
     */
    public Theatre getTheatre() {
        return theatre;
    }

    /**
     * @return the list of movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * gets showtimes for a specific movie from database
     * 
     * @param movie gets the showtimes of this movie
     * @return the list of showtimes for the movie
     */
    public ArrayList<ShowTime> getShowTimes(Movie movie) {
        return movie.getShowTimeList();
    }

    /**
     * gets seats for a specific showtime from database
     * 
     * @param show gets the seats of this showtime
     * @return the list of seats for the showtimes
     */
    public ArrayList<Seat> getSeats(ShowTime show) {
        return show.getSeatList();
    }

    /**
     * gets all coupons in database
     * 
     * @return the list of coupons
     */
    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    /**
     * get the payments in the database
     * 
     * @return the list of payments
     */
    public ArrayList<Payment> getPayments() {
        return payments;
    }

    /**
     * get the tickets in the database
     * 
     * @return the list of tickets
     */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    /**
     * randomly populates the seats in every showtime. Used to simulate a real-life
     * theatre environment
     * 
     * @param tc the ticketcontroller to mange tickets for the randomly populated
     *           seats
     */
    public void populateSeats(TicketController tc) {
        // Randomly Populating Seats to better reflect real life
        for (Movie m : movies) {
            for (ShowTime st : m.getShowTimeList()) {
                if (m.isReleased())
                    Randomizer.populateRandomSeats(st.getSeatList(), tc, 50);
                else
                    Randomizer.populateRandomSeats(st.getSeatList(), tc, 9);
            }
        }
    }
}
