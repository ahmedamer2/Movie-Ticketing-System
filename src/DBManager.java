import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

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
        movies.add(new Movie("Movie1", "genre", "description"));
        movies.add(new Movie("Movie2", "genre", "another description"));

        showTimes = new ArrayList<ShowTime>();
        showTimes.add(new ShowTime(LocalDateTime.now(), 1, 2, movies.get(0)));
        showTimes.add(new ShowTime(LocalDateTime.now(), 1, 2, movies.get(1)));

        seats = new ArrayList<Seat>();
        seats.add(new Seat(0, 0, 20, showTimes.get(0)));
        seats.add(new Seat(0, 1, 20, showTimes.get(0)));
        seats.add(new Seat(0, 0, 20, showTimes.get(1)));
        seats.add(new Seat(0, 1, 20, showTimes.get(1)));

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
